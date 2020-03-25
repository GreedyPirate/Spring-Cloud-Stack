package com.net.timewheel4j;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.DelayQueue;

/**
 * 时间轮
 */
public class TimeWheel {

    /**
     * 一个时间槽的范围
     */
    private long tick;

    /**
     * 时间轮大小
     */
    private int wheelSize;

    /**
     * 时间跨度
     */
    private long interval;

    /**
     * 时间槽
     */
    private TimerTaskList[] timerTaskLists;

    /**
     * 当前时间
     */
    private long currentTime;

    /**
     * 上层时间轮
     */
    private volatile TimeWheel overflowWheel;

    /**
     * 一个Timer只有一个delayQueue
     */
    private DelayQueue<TimerTaskList> delayQueue;

    /**
     * @param tick 间隔时间
     * @param wheelSize 轮子的格数
     * @param currentTime 当前时间
     * @param delayQueue
     */
    public TimeWheel(long tick, int wheelSize, long currentTime, DelayQueue<TimerTaskList> delayQueue) {
        this.tick = tick;
        this.wheelSize = wheelSize;
        this.interval = tick * wheelSize;
        this.timerTaskLists = new TimerTaskList[wheelSize];
        //currentTime为tickMs的整数倍 这里做取整操作
        this.currentTime = currentTime - (currentTime % tick);
        this.delayQueue = delayQueue;
        for (int i = 0; i < wheelSize; i++) {
            timerTaskLists[i] = new TimerTaskList();
        }
    }

    /**
     * 创建或者获取上层时间轮
     */
    private TimeWheel getOverflowWheel() {
        if (overflowWheel == null) {
            synchronized (this) {
                if (overflowWheel == null) {
                    overflowWheel = new TimeWheel(interval, wheelSize, currentTime, delayQueue);
                }
            }
        }
        return overflowWheel;
    }

    /**
     * 添加任务到时间轮
     * @param timerTask 任务
     * @return 任务是否过期，假设当前时间指针到了20s, 添加进来的任务延迟为10s, 已经过期了，直接执行任务
     * 还有个特殊情况，当前为20s的时候，
     */
    public boolean addTask(TimerTask timerTask) {
        // 任务过期时间
        long expiration = timerTask.getDelayMs();
        //过期任务直接执行
        if (expiration < currentTime + tick) {
            return false;
        } else if (expiration < currentTime + interval) {
            //当前时间轮可以容纳该任务 加入时间槽
            long virtualId = expiration / tick;
            int index = (int) (virtualId % wheelSize);
            TimerTaskList timerTaskList = timerTaskLists[index];
            timerTaskList.addTask(timerTask);
            if (timerTaskList.setExpiration(virtualId * tick)) {
                //添加到delayQueue中
                delayQueue.offer(timerTaskList);
            }
        } else {
            //放到上一层的时间轮
            TimeWheel timeWheel = getOverflowWheel();
            timeWheel.addTask(timerTask);
        }
        return true;
    }

    /**
     * 推进时间
     */
    public void advanceClock(long timestamp) {
        System.out.println("timestamp = " + LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()));
        if (timestamp >= currentTime + tick) {
            currentTime = timestamp - (timestamp % tick);
            System.out.println("currentTime = " + LocalDateTime.ofInstant(Instant.ofEpochMilli(currentTime), ZoneId.systemDefault()));
            if (overflowWheel != null) {
                //推进上层时间轮时间
                getOverflowWheel().advanceClock(timestamp);
            }
        }
    }
}
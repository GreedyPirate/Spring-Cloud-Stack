package com.net.timer;

import java.util.concurrent.DelayQueue;

/**
 * Created by Anur IjuoKaruKas on 2018/10/16
 * <p>
 * 时间轮，可以推进时间和添加任务
 */
public class TimeWheel {

    /**
     * 一个时间槽的时间
     */
    private long tickMs;

    /**
     * 时间轮大小
     */
    private int wheelSize;

    /**
     * 时间跨度
     */
    private long interval;

    /**
     * 槽是一个双链表，有wheelSize个槽
     */
    private Bucket[] buckets;

    /**
     * 时间轮指针
     */
    private long currentTimestamp;

    /**
     * 上层时间轮
     */
    private volatile TimeWheel overflowWheel;

    /**
     * 对于一个Timer以及附属的时间轮，都只有一个delayQueue
     */
    private DelayQueue<Bucket> delayQueue;

    public TimeWheel(long tickMs, int wheelSize, long currentTimestamp, DelayQueue<Bucket> delayQueue) {
        this.tickMs = tickMs;
        this.wheelSize = wheelSize;
        this.interval = tickMs * wheelSize;
        this.buckets = new Bucket[wheelSize];
        this.currentTimestamp = currentTimestamp - (currentTimestamp % tickMs);
        this.delayQueue = delayQueue;

        for (int i = 0; i < wheelSize; i++) {
            buckets[i] = new Bucket();
        }
    }

    private TimeWheel getOverflowWheel() {
        if (overflowWheel == null) {
            synchronized (this) {
                if (overflowWheel == null) {
                    overflowWheel = new TimeWheel(interval, wheelSize, currentTimestamp, delayQueue);
                }
            }
        }
        return overflowWheel;
    }

    /**
     * 添加任务到某个时间轮
     */
    public boolean addTask(TimedTask timedTask) {
        // 获取任务的过期时间，时间戳
        long expireTimestamp = timedTask.getExpireTimestamp();
        // 计算延迟毫秒数，即距离当前还有多久到期
        long delayMs = expireTimestamp - currentTimestamp;
        // 假设"秒"级时间轮中,当前指针为10:01分，任务的过期时间为10:01:500, 那么500ms<1s，说明已过期，应立即执行
        if (delayMs < tickMs) {// 到期了
            return false;
        } else { // 未到期

            // 扔进当前时间轮的某个槽中，只有时间【大于某个槽】，才会放进去
            if (delayMs < interval) {
                // 计算要放进第几个槽中
                int bucketIndex = (int) ((expireTimestamp / tickMs) % wheelSize);

                // 根据下标获取环形队列对应的槽对象
                Bucket bucket = buckets[bucketIndex];
                // Bucket是一个双向链表，将任务添加到链表尾部
                bucket.addTask(timedTask);
                //  给槽位设置过期时间，并添加到delayQueue中，它会根据Bucket实现的Delayed接口按过期时间自动排序
                if (bucket.setExpire(expireTimestamp - (expireTimestamp) % tickMs)) {
                    delayQueue.offer(bucket);
                }
            } else {
                // 超出当前时间轮的周期，就新建溢出时间轮
                TimeWheel timeWheel = getOverflowWheel();// 当maybeInThisBucket大于等于wheelSize时，需要将它扔到上一层的时间轮
                // 添加任务，可以看做一个递归过程，直到时间轮的周期大于任务过期时间
                timeWheel.addTask(timedTask);
            }
        }
        return true;
    }

    /**
     * 尝试推进一下指针
     * 其实就是同步每层时间轮的指针为timestamp
     */
    public void advanceClock(long timestamp) {
        if (timestamp >= currentTimestamp + tickMs) {
            System.out.println("timestamp = " + timestamp+",currentTimestamp = "+currentTimestamp+", tickMs = " +tickMs);
            currentTimestamp = timestamp - (timestamp % tickMs);
            System.out.println("currentTimestamp = " + currentTimestamp);
            if (overflowWheel != null) {
                this.getOverflowWheel()
                        .advanceClock(timestamp);
            }
        }
    }

    public static void main(String[] args) {
        long timestamp = 1569383366000L;
        System.out.println("timestamp - (timestamp % 20) = " + (timestamp - (timestamp % 20)));
        System.out.println("timestamp - (timestamp % 200) = " + (timestamp - (timestamp % 200)));
        System.out.println("timestamp - (timestamp % 2000) = " + (timestamp - (timestamp % 2000)));

        int i = 1024 - (1024%10);
        System.out.println(i);
    }
}
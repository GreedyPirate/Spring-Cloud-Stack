package com.net.wheeltimer.wheel;

import java.util.TimerTask;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/17
 * @description 定时器任务
 */
public class WheelTimeTask {
    // 定义定时任务的3个状态：初始化、取消、过期
    public static final int ST_INIT = 0;
    public static final int ST_CANCELLED = 1;
    public static final int ST_EXPIRED = 2;
    /**
     * 表示该任务是否停止
     */
    private int isStop=ST_INIT;
    /**
     * 要执行的任务
     */
    private TimerTask task;
    /**
     * 表示转几圈才开始执行任务
     */
    private int round;

    /**
     * 表示目前分到第几个格子
     */
    private int tickNum;

    /**
     * 超时时间，已转化为该定时器的时间
     */
    private long timeout;

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public int getTickNum() {
        return tickNum;
    }

    public void setTickNum(int tickNum) {
        this.tickNum = tickNum;
    }

    /**
     * 当时间轮走完一圈后，round就需要减一
     */
    public void upRound(){
        round=round-1;
    }

    public int getIsStop() {
        return isStop;
    }

    public void setIsStop(int isStop) {
        this.isStop = isStop;
    }

    public TimerTask getTask() {
        return task;
    }

    public void setTask(TimerTask task) {
        this.task = task;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}

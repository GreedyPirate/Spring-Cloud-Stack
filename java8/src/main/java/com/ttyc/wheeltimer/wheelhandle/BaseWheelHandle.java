package com.ttyc.wheeltimer.wheelhandle;

import com.ttyc.wheeltimer.wheel.WheelTimeTask;
import com.ttyc.wheeltimer.wheel.WheelTimer;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/21
 * @description 基础轮子处理
 */
public abstract class BaseWheelHandle {
    WheelTimer wheelTimer;
    public BaseWheelHandle(WheelTimer wheelTimer) {
        this.wheelTimer = wheelTimer;
    }

    public  void handle(){
        while (true){
            //运行最小轮子的任务
            runTask();
            //槽走一格
            gotoNextTick();
            //给槽增加任务
            addTaskToTicks(wheelTimer.getAddTimeOuts());
            //移除任务
            removeTaskToTicks(wheelTimer.getRemoveTimeOuts());
            try {
                //线程睡觉
                wheelTimer.getTimeUnit().sleep(wheelTimer.getMinTickDuration());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 跳转到下一格子
     */
    protected abstract void gotoNextTick();

    /**
     * 增减任务
     * @param wheelTimeTasks
     */
    protected abstract void addTaskToTicks(ConcurrentLinkedQueue<WheelTimeTask> wheelTimeTasks);

    /**
     * 移除任务
     * @param wheelTimeTasks
     */
    protected abstract void removeTaskToTicks(ConcurrentLinkedQueue<WheelTimeTask> wheelTimeTasks);
     /**
     * 获取任务链执行任务
     */
     protected abstract void runTask();
}

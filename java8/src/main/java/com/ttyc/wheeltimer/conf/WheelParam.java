package com.ttyc.wheeltimer.conf;


import com.ttyc.wheeltimer.wheel.Tick;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/21
 * @description 轮的配置参数
 */
public class WheelParam {
    /**
     * 此轮子的时间间隔
     */
    int ticksDuration;

    /**
     * 一圈有几个格子
     */
    int ticksPerWheel;
    /**
     * 格子数
     */
    Tick[] ticks;
    public WheelParam(int ticksPerWheel) {
        this.ticksPerWheel = ticksPerWheel;
        initTicks();
    }

    public int getTicksDuration() {
        return ticksDuration;
    }

    public void setTicksDuration(int ticksDuration) {
        this.ticksDuration = ticksDuration;
    }

    /**
     * 初始化轮子的格子数
     */
    private void initTicks(){
        ticks=new Tick[ticksPerWheel];
        for (int i=0;i<ticksPerWheel;i++){
            ticks[i]=new Tick();
        }
    }
    public int getTicksPerWheel() {
        return ticksPerWheel;
    }

    public void setTicksPerWheel(int ticksPerWheel) {
        this.ticksPerWheel = ticksPerWheel;
    }

    public Tick[] getTicks() {
        return ticks;
    }

    public void setTicks(Tick[] ticks) {
        this.ticks = ticks;
    }
}

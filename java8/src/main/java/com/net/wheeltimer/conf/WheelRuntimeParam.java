package com.net.wheeltimer.conf;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/21
 * @description 轮子运行时参数
 */
public class WheelRuntimeParam {
    public WheelRuntimeParam(int currTick, WheelParam wheelParam) {
        this.currTick = currTick;
        this.wheelParam = wheelParam;
    }

    /**
     * 当前所在的槽
     */
    private int currTick=0;
    /**
     * 轮子配置参数
     */
    private WheelParam wheelParam;

    /**
     * 槽自增1
     */
    public  void currTickAdd(){
        currTick++;
    }

    public int getCurrTick() {
        return currTick;
    }

    public void setCurrTick(int currTick) {
        this.currTick = currTick;
    }

    public WheelParam getWheelParam() {
        return wheelParam;
    }

    public void setWheelParam(WheelParam wheelParam) {
        this.wheelParam = wheelParam;
    }
}

package com.ttyc.wheeltimer.worker;

import com.ttyc.wheeltimer.wheel.WheelTimer;
import com.ttyc.wheeltimer.wheelhandle.BaseWheelHandle;
import com.ttyc.wheeltimer.wheelhandle.MulitWheelHandle;
import com.ttyc.wheeltimer.wheelhandle.SingelWheelHandle;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/21
 * @description 时间轮工作
 */
public class WheelTimerWorker implements Runnable{
    WheelTimer wheelTimer;
    public WheelTimerWorker(WheelTimer wheelTimer) {
        this.wheelTimer=wheelTimer;
    }

    @Override
    public void run() {
        //开始判断是单轮还是多轮子
        BaseWheelHandle wheelHandle = null;
        if (isMulitWheel()){
            //多轮子
            wheelHandle=new MulitWheelHandle(wheelTimer);
        }else{
            //单轮子
            wheelHandle=new SingelWheelHandle(wheelTimer);
        }
        wheelHandle.handle();
    }

    private boolean isMulitWheel(){
        return wheelTimer.getRuntimeParam()==null? true:false;
    }
}

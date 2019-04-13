package com.net.wheeltimer.test;


import com.net.wheeltimer.conf.WheelParam;
import com.net.wheeltimer.exception.TimeoutLongException;
import com.net.wheeltimer.wheel.WheelTimer;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/18
 * @description
 */
public class WheelTest {
    public static void main(String [] args) throws TimeoutLongException{
        WheelParam[] wheelParam=new WheelParam[]{
                new WheelParam(10),
                new WheelParam(15),
                new WheelParam(20)
        };
        final WheelTimer timer=new WheelTimer(wheelParam,TimeUnit.SECONDS,3);
        timer.start();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                int num=(int)(Math.random()*30)+1;
                System.out.println("--------------   ");
                System.out.println("定时任务执行   "+num+ "秒后执行");
                System.out.println("--------------   ");
                try {
                    timer.addTimeTaskByTimeOut(this,num,TimeUnit.SECONDS);
                } catch (TimeoutLongException e) {

                }
            }
        };

        TimerTask task1=new TimerTask() {
            @Override
            public void run() {
                int num=(int)(Math.random()*60)+1;
                try {
                    timer.addTimeTaskByTimeOut(this,num,TimeUnit.SECONDS);
                } catch (TimeoutLongException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println("addTimeTaskByTimeOut   ");
        timer.addTimeTaskByTimeOut(task,3,TimeUnit.SECONDS);
        timer.addTimeTaskByTimeOut(task1,30,TimeUnit.SECONDS);
    }
}

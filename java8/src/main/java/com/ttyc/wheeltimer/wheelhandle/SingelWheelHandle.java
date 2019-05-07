package com.ttyc.wheeltimer.wheelhandle;

import com.ttyc.wheeltimer.wheel.Tick;
import com.ttyc.wheeltimer.wheel.WheelTimeTask;
import com.ttyc.wheeltimer.wheel.WheelTimer;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/21
 * @description 单个轮子的处理
 */
public class SingelWheelHandle extends BaseWheelHandle{
    public SingelWheelHandle(WheelTimer wheelTimer) {
        super(wheelTimer);
    }
    /**
     * 跳转到下一个格子
     */
    @Override
    protected void gotoNextTick(){
        //如果当前格子数与总格子数相等，格子数归为0 圈数+1
        if (wheelTimer.getRuntimeParam().getCurrTick()==wheelTimer.getRuntimeParam().getWheelParam().getTicksPerWheel()-1){
            wheelTimer.getRuntimeParam().setCurrTick(0);
        }else{
            //槽走一格
            wheelTimer.getRuntimeParam().currTickAdd();
        }
    }

    @Override
    protected void addTaskToTicks(ConcurrentLinkedQueue<WheelTimeTask> wheelTimeTasks) {
        //增加任务到tick
        while (!wheelTimeTasks.isEmpty()){
            //获取一个任务
            WheelTimeTask addTimeOut=wheelTimeTasks.poll();
            if(addTimeOut!=null){
                //计算该任务加到第一个格子中
                long timeout=addTimeOut.getTimeout();
                //（（超时时间/间隔时间）+目前的tick）
                double tick= (timeout*1.0)/wheelTimer.getMinTickDuration();
                long allTick= (long) (Math.ceil(tick)+wheelTimer.getRuntimeParam().getCurrTick());
                //第几圈
                long round= (long) (Math.ceil(tick)/wheelTimer.getRuntimeParam().getWheelParam().getTicksPerWheel());
                //第几个格子
                long taskTick=allTick%wheelTimer.getRuntimeParam().getWheelParam().getTicksPerWheel();
                System.out.println("目前是第几个格子   "+wheelTimer.getRuntimeParam().getCurrTick()+" 当前任务放在第几个格子  "+taskTick);
                addTimeOut.setRound((int) round);
                addTimeOut.setTickNum((int) taskTick);
                wheelTimer.getRuntimeParam().getWheelParam().getTicks()[(int) taskTick].getTimeOuts().add(addTimeOut);
            }
        }
    }

    @Override
    protected void removeTaskToTicks(ConcurrentLinkedQueue<WheelTimeTask> wheelTimeTasks) {

    }

    @Override
    protected  void runTask(){
        System.out.println("单轮定时器开始走格子  "+wheelTimer.getRuntimeParam().getCurrTick());
        Tick tick=wheelTimer.getRuntimeParam().getWheelParam().getTicks()[wheelTimer.getRuntimeParam().getCurrTick()];
        Iterator<WheelTimeTask> iterable=tick.getTimeOuts().iterator();
        while (iterable.hasNext()){
            WheelTimeTask timeOut=iterable.next();
            if (timeOut.getRound()<=0&&timeOut.getIsStop()!=WheelTimeTask.ST_CANCELLED){
                //如果round=目前圈数且指针转动到相应的tick时，执行任务
                timeOut.getTask().run();
                //移除该任务
                iterable.remove();
            }else{
                timeOut.upRound();
            }
        }
    }
}

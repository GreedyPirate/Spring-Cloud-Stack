package com.ttyc.wheeltimer.wheelhandle;

import com.ttyc.wheeltimer.conf.WheelRuntimeParam;
import com.ttyc.wheeltimer.wheel.Tick;
import com.ttyc.wheeltimer.wheel.WheelTimeTask;
import com.ttyc.wheeltimer.wheel.WheelTimer;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/21
 * @description 多轮子
 */
public class MulitWheelHandle extends BaseWheelHandle {
    public MulitWheelHandle(WheelTimer wheelTimer) {
        super(wheelTimer);
    }

    @Override
    protected void gotoNextTick() {
        gotoNextTick(0);
    }

    /**
     * 跳转下一个槽
     * @param wheelIndex 轮子索引
     */
    private void gotoNextTick(int wheelIndex){
        WheelRuntimeParam runtimeParam=wheelTimer.getRuntimeParams()[wheelIndex];
        if (runtimeParam.getCurrTick()==runtimeParam.getWheelParam().getTicks().length-1){
            //已经转到一圈了
            //判断是否有剩余的轮子
            if (wheelIndex<wheelTimer.getRuntimeParams().length-1){
                //表示有剩余的轮子
                gotoNextTick(++wheelIndex);
            }
            System.out.println(wheelIndex+"号轮子转到一圈  "+" 归0");
            //归0
            runtimeParam.setCurrTick(0);
        }else{
            //没有转到一圈,自增
            System.out.println(wheelIndex+"号轮子没有转到一圈  "+" 自增");
            runtimeParam.currTickAdd();
        }

        addTaskToQueue(wheelIndex,runtimeParam);
    }

    /**
     * 增加任务到队列中
     * @param runtimeParam
     */
    private void addTaskToQueue(int wheelIndex,WheelRuntimeParam runtimeParam){
        //排除第0个轮子
        if (wheelIndex!=0){
            Tick tick=runtimeParam.getWheelParam().getTicks()[runtimeParam.getCurrTick()];
            Set<WheelTimeTask> timeTasks=tick.getTimeOuts();
            Iterator<WheelTimeTask> iterator= timeTasks.iterator();
            int tickDuration=runtimeParam.getWheelParam().getTicksDuration();
            while (iterator.hasNext()){
                WheelTimeTask wheelTimeTask=iterator.next();
                if (wheelTimeTask.getIsStop()!=WheelTimeTask.ST_CANCELLED){
                    //判断任务时间，相减
                    long dtTime=wheelTimeTask.getTimeout()/runtimeParam.getWheelParam().getTicksDuration();
                    System.out.println(wheelIndex+"号轮子  "+"  增加任务  "+"currtick       "+runtimeParam.getCurrTick()+" timeout  "+wheelTimeTask.getTimeout()+"dtime  "+dtTime);
                    wheelTimeTask.setTimeout(dtTime);
                    wheelTimer.getAddTimeOuts().add(wheelTimeTask);
                }
                iterator.remove();
            }
        }
    }

    @Override
    protected void addTaskToTicks(ConcurrentLinkedQueue<WheelTimeTask> wheelTimeTasks) {
        //增加任务到tick
        while (!wheelTimeTasks.isEmpty()){
            WheelTimeTask timeTask=wheelTimeTasks.poll();
            addTaskToTicks(0,timeTask);
        }
    }
    private void addTaskToTicks(int wheelIndex,WheelTimeTask task){
        WheelRuntimeParam runtimeParam=wheelTimer.getRuntimeParams()[wheelIndex];
        //判断当前轮子是否满足时间
        long totalTime=runtimeParam.getWheelParam().getTicksDuration()*runtimeParam.getWheelParam().getTicksPerWheel();
        if (totalTime>task.getTimeout()){
            //表示满足
            //计算该任务加到第几个个格子中
            long timeout=task.getTimeout();
            double tick= (timeout*1.0)/runtimeParam.getWheelParam().getTicksDuration();
            long allTick= (long) (Math.ceil(tick)+runtimeParam.getCurrTick());
            long taskTick=allTick%runtimeParam.getWheelParam().getTicksPerWheel();
            System.out.println("任务加到第  "+wheelIndex+"个轮子 "+"第 "+taskTick+"个格子");
            runtimeParam.getWheelParam().getTicks()[(int) taskTick].getTimeOuts().add(task);
        }else{
            //判断是否有上层轮子
            if(wheelIndex<wheelTimer.getRuntimeParams().length){
                //有上层轮子
                addTaskToTicks(++wheelIndex,task);
            }else{
                System.out.println("没有一个轮子满足此超时时间   ");
            }
        }
    }

    @Override
    protected void removeTaskToTicks(ConcurrentLinkedQueue<WheelTimeTask> wheelTimeTasks) {

    }

    @Override
    protected void runTask() {
      //运行最小轮子的任务
        System.out.println("运行最小轮子    ");
        Tick[] ticks=wheelTimer.getRuntimeParams()[0].getWheelParam().getTicks();
        Tick tick=ticks[wheelTimer.getRuntimeParams()[0].getCurrTick()];
        //获取任务链
        Set<WheelTimeTask> timeTasks=tick.getTimeOuts();
        Iterator<WheelTimeTask> iterator= timeTasks.iterator();
        while (iterator.hasNext()){
            WheelTimeTask wheelTimeTask=iterator.next();
            //判断是否执行
            if (wheelTimeTask.getIsStop()!=WheelTimeTask.ST_CANCELLED){
                wheelTimeTask.getTask().run();
            }
            iterator.remove();
        }
    }
}

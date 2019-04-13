package com.net.wheeltimer.wheel;

import com.net.wheeltimer.conf.WheelParam;
import com.net.wheeltimer.conf.WheelRuntimeParam;
import com.net.wheeltimer.exception.TimeoutLongException;
import com.net.wheeltimer.worker.WheelTimerWorker;

import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/17
 * @description 时间轮
 */
public class WheelTimer {
    /**
     * 时间轮线程
     */
    Thread thread;
    /**
     * 时间单位的枚举类
     */
    TimeUnit timeUnit;
    /**
     * 走一格最小轮子需要的时间长度
     */
    int minTickDuration;
    /**
     * 增加的超时任务列表，在时间轮跳转到下次tick时，遍历这个
     */
    ConcurrentLinkedQueue<WheelTimeTask> addTimeOuts=new ConcurrentLinkedQueue<WheelTimeTask>();
    /**
     * 移除的timeout任务列表
     */
    ConcurrentLinkedQueue<WheelTimeTask> removeTimeOuts=new ConcurrentLinkedQueue<WheelTimeTask>();

    /**
     * 单个轮子的配置
     */
    WheelRuntimeParam runtimeParam;

    /**
     * 多个轮子的配置
     */

    WheelRuntimeParam[] runtimeParams;

    /**
     * 单个轮子的初始化
     * @param wheelParam
     * @param timeUnit
     * @param minTickDuration
     */

    public WheelTimer(WheelParam wheelParam, TimeUnit timeUnit, int minTickDuration) {
        this.timeUnit = timeUnit;
        this.minTickDuration = minTickDuration;
        thread=new Thread(new WheelTimerWorker(this));
        initSingleWheel(wheelParam);
    }

    /**
     * 多个轮子的初始化
     * @param wheelParams
     * @param timeUnit
     * @param minTickDuration
     */
    public WheelTimer(WheelParam[] wheelParams,TimeUnit timeUnit, int minTickDuration) {
        this.timeUnit = timeUnit;
        this.minTickDuration = minTickDuration;
        thread=new Thread(new WheelTimerWorker(this));
        initMulitWheel(wheelParams);
    }

    void initSingleWheel(WheelParam wheelParam){
        WheelRuntimeParam runtimeSingnelParam=new WheelRuntimeParam(0,wheelParam);
        runtimeParam=runtimeSingnelParam;
    }

    void initMulitWheel(WheelParam[] wheelParams){
        runtimeParams=new WheelRuntimeParam[wheelParams.length];
        for (int i=0;i<wheelParams.length;i++){
            if (i==0){
                wheelParams[i].setTicksDuration(minTickDuration);
            }else{
                wheelParams[i].setTicksDuration(wheelParams[i-1].getTicksDuration()*wheelParams[i-1].getTicksPerWheel());
            }
            WheelRuntimeParam runtimeMulitParam=new WheelRuntimeParam(0,wheelParams[i]);
            runtimeParams[i]=runtimeMulitParam;
        }
    }
    /**
     * 通过超时时间增加超时任务
     * @param task 超时任务
     * @param timeout 超时时间
     * @param taskTimeUnit 超时时间单位
     */
    public WheelTimeTask addTimeTaskByTimeOut(TimerTask task, long timeout, TimeUnit taskTimeUnit) throws TimeoutLongException {
        System.out.println("通过超时时间增加超时任务   ");
        //判断如果是多轮模式是否添加的时间超过当前时间跨度
        if(runtimeParams!=null){
            //多轮模式
            long duration=runtimeParams[runtimeParams.length-1].getWheelParam().getTicksDuration();
            long ticks=runtimeParams[runtimeParams.length-1].getWheelParam().getTicks().length;
            if(timeUnit.convert(timeout,taskTimeUnit)>(duration*ticks)){
                throw new TimeoutLongException("时间跨度太长");
            }
        }
        WheelTimeTask wheelTimeTask =new WheelTimeTask();
        wheelTimeTask.setTask(task);
        wheelTimeTask.setIsStop(WheelTimeTask.ST_INIT);
        wheelTimeTask.setTimeout(timeUnit.convert(timeout,taskTimeUnit));
        addTimeOuts.add(wheelTimeTask);
        return wheelTimeTask;
    }

    public void removeTimeTask(){

    }
    /**
     * 时间轮启动
     */
    public void start(){
        thread.start();
        System.out.println("timer thread  run ");
    }

    /**
     * 定时器重启
     */
    public void wheelTimerRestart(){

    }

    /**
     * 定时器停止
     */
    public void wheelTimerStop(){

    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getMinTickDuration() {
        return minTickDuration;
    }

    public void setMinTickDuration(int minTickDuration) {
        this.minTickDuration = minTickDuration;
    }

    public WheelRuntimeParam getRuntimeParam() {
        return runtimeParam;
    }

    public void setRuntimeParam(WheelRuntimeParam runtimeParam) {
        this.runtimeParam = runtimeParam;
    }

    public WheelRuntimeParam[] getRuntimeParams() {
        return runtimeParams;
    }

    public void setRuntimeParams(WheelRuntimeParam[] runtimeParams) {
        this.runtimeParams = runtimeParams;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public ConcurrentLinkedQueue<WheelTimeTask> getAddTimeOuts() {
        return addTimeOuts;
    }

    public void setAddTimeOuts(ConcurrentLinkedQueue<WheelTimeTask> addTimeOuts) {
        this.addTimeOuts = addTimeOuts;
    }

    public ConcurrentLinkedQueue<WheelTimeTask> getRemoveTimeOuts() {
        return removeTimeOuts;
    }

    public void setRemoveTimeOuts(ConcurrentLinkedQueue<WheelTimeTask> removeTimeOuts) {
        this.removeTimeOuts = removeTimeOuts;
    }
}
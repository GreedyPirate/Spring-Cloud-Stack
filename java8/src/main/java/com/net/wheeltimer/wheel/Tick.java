package com.net.wheeltimer.wheel;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/17
 * @description tick 滴答
 */
public class Tick {
    /**
     * 一个槽中的任务列表
     */
    private Set<WheelTimeTask> timeOuts=new HashSet<WheelTimeTask>();

    public Set<WheelTimeTask> getTimeOuts() {
        return timeOuts;
    }

    public void setTimeOuts(Set<WheelTimeTask> timeOuts) {
        this.timeOuts = timeOuts;
    }
}

package com.ttyc.delay;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Data
public class Task implements Delayed{

    private Date executeTime;

    public Task(Date executeTime) {
        this.executeTime = executeTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Task task = (Task) o;
        return task.executeTime.compareTo(this.executeTime);
    }

    public void print() {
        System.out.println("executeTime = " + executeTime);
    }
}

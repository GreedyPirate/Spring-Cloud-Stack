package com.net.mytimer;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TaskList implements Delayed{

    private TaskEntry head;

    private long expireTime;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expireTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(o == this) return 0;

        TaskList other = (TaskList) o;
        long differ = expireTime - other.expireTime;
        if(differ < 0) {
            return -1;
        }else if(differ > 0) {
            return 1;
        }
        return 0;
    }

    class TaskEntry<T extends Runnable> {
        protected T task;

        public TaskEntry(T task) {
            this.task = task;
        }

        public T getTask() {
            return task;
        }
    }
}



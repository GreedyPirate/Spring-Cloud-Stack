/*
 * This file is generated by jOOQ.
*/
package com.example.domain.jooq.tables.pojos;


import javax.annotation.Generated;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JobExecutionLog implements Serializable {

    private static final long serialVersionUID = 1015780585;

    private String    id;
    private String    jobName;
    private String    taskId;
    private String    hostname;
    private String    ip;
    private Integer   shardingItem;
    private String    executionSource;
    private String    failureCause;
    private Integer   isSuccess;
    private Timestamp startTime;
    private Timestamp completeTime;

    public JobExecutionLog() {}

    public JobExecutionLog(JobExecutionLog value) {
        this.id = value.id;
        this.jobName = value.jobName;
        this.taskId = value.taskId;
        this.hostname = value.hostname;
        this.ip = value.ip;
        this.shardingItem = value.shardingItem;
        this.executionSource = value.executionSource;
        this.failureCause = value.failureCause;
        this.isSuccess = value.isSuccess;
        this.startTime = value.startTime;
        this.completeTime = value.completeTime;
    }

    public JobExecutionLog(
        String    id,
        String    jobName,
        String    taskId,
        String    hostname,
        String    ip,
        Integer   shardingItem,
        String    executionSource,
        String    failureCause,
        Integer   isSuccess,
        Timestamp startTime,
        Timestamp completeTime
    ) {
        this.id = id;
        this.jobName = jobName;
        this.taskId = taskId;
        this.hostname = hostname;
        this.ip = ip;
        this.shardingItem = shardingItem;
        this.executionSource = executionSource;
        this.failureCause = failureCause;
        this.isSuccess = isSuccess;
        this.startTime = startTime;
        this.completeTime = completeTime;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getShardingItem() {
        return this.shardingItem;
    }

    public void setShardingItem(Integer shardingItem) {
        this.shardingItem = shardingItem;
    }

    public String getExecutionSource() {
        return this.executionSource;
    }

    public void setExecutionSource(String executionSource) {
        this.executionSource = executionSource;
    }

    public String getFailureCause() {
        return this.failureCause;
    }

    public void setFailureCause(String failureCause) {
        this.failureCause = failureCause;
    }

    public Integer getIsSuccess() {
        return this.isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Timestamp getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getCompleteTime() {
        return this.completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JobExecutionLog (");

        sb.append(id);
        sb.append(", ").append(jobName);
        sb.append(", ").append(taskId);
        sb.append(", ").append(hostname);
        sb.append(", ").append(ip);
        sb.append(", ").append(shardingItem);
        sb.append(", ").append(executionSource);
        sb.append(", ").append(failureCause);
        sb.append(", ").append(isSuccess);
        sb.append(", ").append(startTime);
        sb.append(", ").append(completeTime);

        sb.append(")");
        return sb.toString();
    }
}

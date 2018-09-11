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
public class JobStatusTraceLog implements Serializable {

    private static final long serialVersionUID = -1142380343;

    private String    id;
    private String    jobName;
    private String    originalTaskId;
    private String    taskId;
    private String    slaveId;
    private String    source;
    private String    executionType;
    private String    shardingItem;
    private String    state;
    private String    message;
    private Timestamp creationTime;

    public JobStatusTraceLog() {}

    public JobStatusTraceLog(JobStatusTraceLog value) {
        this.id = value.id;
        this.jobName = value.jobName;
        this.originalTaskId = value.originalTaskId;
        this.taskId = value.taskId;
        this.slaveId = value.slaveId;
        this.source = value.source;
        this.executionType = value.executionType;
        this.shardingItem = value.shardingItem;
        this.state = value.state;
        this.message = value.message;
        this.creationTime = value.creationTime;
    }

    public JobStatusTraceLog(
        String    id,
        String    jobName,
        String    originalTaskId,
        String    taskId,
        String    slaveId,
        String    source,
        String    executionType,
        String    shardingItem,
        String    state,
        String    message,
        Timestamp creationTime
    ) {
        this.id = id;
        this.jobName = jobName;
        this.originalTaskId = originalTaskId;
        this.taskId = taskId;
        this.slaveId = slaveId;
        this.source = source;
        this.executionType = executionType;
        this.shardingItem = shardingItem;
        this.state = state;
        this.message = message;
        this.creationTime = creationTime;
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

    public String getOriginalTaskId() {
        return this.originalTaskId;
    }

    public void setOriginalTaskId(String originalTaskId) {
        this.originalTaskId = originalTaskId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getSlaveId() {
        return this.slaveId;
    }

    public void setSlaveId(String slaveId) {
        this.slaveId = slaveId;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExecutionType() {
        return this.executionType;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    public String getShardingItem() {
        return this.shardingItem;
    }

    public void setShardingItem(String shardingItem) {
        this.shardingItem = shardingItem;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JobStatusTraceLog (");

        sb.append(id);
        sb.append(", ").append(jobName);
        sb.append(", ").append(originalTaskId);
        sb.append(", ").append(taskId);
        sb.append(", ").append(slaveId);
        sb.append(", ").append(source);
        sb.append(", ").append(executionType);
        sb.append(", ").append(shardingItem);
        sb.append(", ").append(state);
        sb.append(", ").append(message);
        sb.append(", ").append(creationTime);

        sb.append(")");
        return sb.toString();
    }
}

/*
 * This file is generated by jOOQ.
*/
package com.example.domain.jooq.tables.records;


import com.example.domain.jooq.tables.CarOpLog;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


/**
 * 车辆操作记录
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CarOpLogRecord extends UpdatableRecordImpl<CarOpLogRecord> implements Record15<Long, Boolean, Long, String, Boolean, Boolean, Boolean, Timestamp, Timestamp, Boolean, Boolean, String, String, Long, String> {

    private static final long serialVersionUID = -329097481;

    /**
     * Setter for <code>jay.car_op_log.id</code>. 主键
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>jay.car_op_log.id</code>. 主键
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>jay.car_op_log.user_type</code>. 用户类型
     */
    public void setUserType(Boolean value) {
        set(1, value);
    }

    /**
     * Getter for <code>jay.car_op_log.user_type</code>. 用户类型
     */
    public Boolean getUserType() {
        return (Boolean) get(1);
    }

    /**
     * Setter for <code>jay.car_op_log.user_id</code>. 用户id
     */
    public void setUserId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>jay.car_op_log.user_id</code>. 用户id
     */
    public Long getUserId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>jay.car_op_log.car_sn</code>. 车辆编号
     */
    public void setCarSn(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>jay.car_op_log.car_sn</code>. 车辆编号
     */
    public String getCarSn() {
        return (String) get(3);
    }

    /**
     * Setter for <code>jay.car_op_log.op_type</code>. 操作类型1开锁2结束用车3临时开锁4临时关锁5寻车
     */
    public void setOpType(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>jay.car_op_log.op_type</code>. 操作类型1开锁2结束用车3临时开锁4临时关锁5寻车
     */
    public Boolean getOpType() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>jay.car_op_log.op_result</code>. 操作结果0待确认1成功2失败3超时
     */
    public void setOpResult(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>jay.car_op_log.op_result</code>. 操作结果0待确认1成功2失败3超时
     */
    public Boolean getOpResult() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>jay.car_op_log.client_type</code>. 操作渠道：1:ios，2:android，3:运营后台
     */
    public void setClientType(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>jay.car_op_log.client_type</code>. 操作渠道：1:ios，2:android，3:运营后台
     */
    public Boolean getClientType() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>jay.car_op_log.create_time</code>. 开始时间
     */
    public void setCreateTime(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>jay.car_op_log.create_time</code>. 开始时间
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>jay.car_op_log.update_time</code>. 结束时间
     */
    public void setUpdateTime(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>jay.car_op_log.update_time</code>. 结束时间
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>jay.car_op_log.channel_type</code>. 下发方式
     */
    public void setChannelType(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>jay.car_op_log.channel_type</code>. 下发方式
     */
    public Boolean getChannelType() {
        return (Boolean) get(9);
    }

    /**
     * Setter for <code>jay.car_op_log.car_status</code>. 车辆使用状态
     */
    public void setCarStatus(Boolean value) {
        set(10, value);
    }

    /**
     * Getter for <code>jay.car_op_log.car_status</code>. 车辆使用状态
     */
    public Boolean getCarStatus() {
        return (Boolean) get(10);
    }

    /**
     * Setter for <code>jay.car_op_log.snap_shot</code>. 车辆快照信息，json格式
     */
    public void setSnapShot(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>jay.car_op_log.snap_shot</code>. 车辆快照信息，json格式
     */
    public String getSnapShot() {
        return (String) get(11);
    }

    /**
     * Setter for <code>jay.car_op_log.fail_reason</code>. 失败原因,允许多个原因同时存在:(1,"ACC处于打开状态"),(2,"ACC处于关闭状态"),(3,"车门处于打开状态"),(4,"车门处于关闭状态"),(5,"车窗处于打开状态"),(6,"车窗处于关闭状态"),(7,"继电器处于打开状态"),(8,"继电器处于关闭状态"),(9,"车锁处于打开状态"),(10,"车锁处于关闭状态"),(11,"车灯处于打开状态"),(12,"车灯处于关闭状态");
     */
    public void setFailReason(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>jay.car_op_log.fail_reason</code>. 失败原因,允许多个原因同时存在:(1,"ACC处于打开状态"),(2,"ACC处于关闭状态"),(3,"车门处于打开状态"),(4,"车门处于关闭状态"),(5,"车窗处于打开状态"),(6,"车窗处于关闭状态"),(7,"继电器处于打开状态"),(8,"继电器处于关闭状态"),(9,"车锁处于打开状态"),(10,"车锁处于关闭状态"),(11,"车灯处于打开状态"),(12,"车灯处于关闭状态");
     */
    public String getFailReason() {
        return (String) get(12);
    }

    /**
     * Setter for <code>jay.car_op_log.op_id</code>. 操作id
     */
    public void setOpId(Long value) {
        set(13, value);
    }

    /**
     * Getter for <code>jay.car_op_log.op_id</code>. 操作id
     */
    public Long getOpId() {
        return (Long) get(13);
    }

    /**
     * Setter for <code>jay.car_op_log.order_sn</code>. 订单编号
     */
    public void setOrderSn(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>jay.car_op_log.order_sn</code>. 订单编号
     */
    public String getOrderSn() {
        return (String) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<Long, Boolean, Long, String, Boolean, Boolean, Boolean, Timestamp, Timestamp, Boolean, Boolean, String, String, Long, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<Long, Boolean, Long, String, Boolean, Boolean, Boolean, Timestamp, Timestamp, Boolean, Boolean, String, String, Long, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return CarOpLog.CAR_OP_LOG.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field2() {
        return CarOpLog.CAR_OP_LOG.USER_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return CarOpLog.CAR_OP_LOG.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return CarOpLog.CAR_OP_LOG.CAR_SN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return CarOpLog.CAR_OP_LOG.OP_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return CarOpLog.CAR_OP_LOG.OP_RESULT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field7() {
        return CarOpLog.CAR_OP_LOG.CLIENT_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return CarOpLog.CAR_OP_LOG.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return CarOpLog.CAR_OP_LOG.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field10() {
        return CarOpLog.CAR_OP_LOG.CHANNEL_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field11() {
        return CarOpLog.CAR_OP_LOG.CAR_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return CarOpLog.CAR_OP_LOG.SNAP_SHOT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return CarOpLog.CAR_OP_LOG.FAIL_REASON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field14() {
        return CarOpLog.CAR_OP_LOG.OP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return CarOpLog.CAR_OP_LOG.ORDER_SN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component2() {
        return getUserType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getCarSn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component5() {
        return getOpType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component6() {
        return getOpResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component7() {
        return getClientType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component9() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component10() {
        return getChannelType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component11() {
        return getCarStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getSnapShot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getFailReason();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component14() {
        return getOpId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getOrderSn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value2() {
        return getUserType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getCarSn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getOpType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getOpResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value7() {
        return getClientType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value10() {
        return getChannelType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value11() {
        return getCarStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getSnapShot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getFailReason();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value14() {
        return getOpId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getOrderSn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value2(Boolean value) {
        setUserType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value3(Long value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value4(String value) {
        setCarSn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value5(Boolean value) {
        setOpType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value6(Boolean value) {
        setOpResult(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value7(Boolean value) {
        setClientType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value8(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value9(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value10(Boolean value) {
        setChannelType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value11(Boolean value) {
        setCarStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value12(String value) {
        setSnapShot(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value13(String value) {
        setFailReason(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value14(Long value) {
        setOpId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord value15(String value) {
        setOrderSn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLogRecord values(Long value1, Boolean value2, Long value3, String value4, Boolean value5, Boolean value6, Boolean value7, Timestamp value8, Timestamp value9, Boolean value10, Boolean value11, String value12, String value13, Long value14, String value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CarOpLogRecord
     */
    public CarOpLogRecord() {
        super(CarOpLog.CAR_OP_LOG);
    }

    /**
     * Create a detached, initialised CarOpLogRecord
     */
    public CarOpLogRecord(Long id, Boolean userType, Long userId, String carSn, Boolean opType, Boolean opResult, Boolean clientType, Timestamp createTime, Timestamp updateTime, Boolean channelType, Boolean carStatus, String snapShot, String failReason, Long opId, String orderSn) {
        super(CarOpLog.CAR_OP_LOG);

        set(0, id);
        set(1, userType);
        set(2, userId);
        set(3, carSn);
        set(4, opType);
        set(5, opResult);
        set(6, clientType);
        set(7, createTime);
        set(8, updateTime);
        set(9, channelType);
        set(10, carStatus);
        set(11, snapShot);
        set(12, failReason);
        set(13, opId);
        set(14, orderSn);
    }
}

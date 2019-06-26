/*
 * This file is generated by jOOQ.
*/
package com.example.domain.jooq.tables;


import com.example.domain.jooq.Indexes;
import com.example.domain.jooq.Jay;
import com.example.domain.jooq.Keys;
import com.example.domain.jooq.tables.records.CarOpLogRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class CarOpLog extends TableImpl<CarOpLogRecord> {

    private static final long serialVersionUID = -222900117;

    /**
     * The reference instance of <code>jay.car_op_log</code>
     */
    public static final CarOpLog CAR_OP_LOG = new CarOpLog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CarOpLogRecord> getRecordType() {
        return CarOpLogRecord.class;
    }

    /**
     * The column <code>jay.car_op_log.id</code>. 主键
     */
    public final TableField<CarOpLogRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "主键");

    /**
     * The column <code>jay.car_op_log.user_type</code>. 用户类型
     */
    public final TableField<CarOpLogRecord, Boolean> USER_TYPE = createField("user_type", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "用户类型");

    /**
     * The column <code>jay.car_op_log.user_id</code>. 用户id
     */
    public final TableField<CarOpLogRecord, Long> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "用户id");

    /**
     * The column <code>jay.car_op_log.car_sn</code>. 车辆编号
     */
    public final TableField<CarOpLogRecord, String> CAR_SN = createField("car_sn", org.jooq.impl.SQLDataType.CHAR(17).nullable(false), this, "车辆编号");

    /**
     * The column <code>jay.car_op_log.op_type</code>. 操作类型1开锁2结束用车3临时开锁4临时关锁5寻车
     */
    public final TableField<CarOpLogRecord, Boolean> OP_TYPE = createField("op_type", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "操作类型1开锁2结束用车3临时开锁4临时关锁5寻车");

    /**
     * The column <code>jay.car_op_log.op_result</code>. 操作结果0待确认1成功2失败3超时
     */
    public final TableField<CarOpLogRecord, Boolean> OP_RESULT = createField("op_result", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "操作结果0待确认1成功2失败3超时");

    /**
     * The column <code>jay.car_op_log.client_type</code>. 操作渠道：1:ios，2:android，3:运营后台
     */
    public final TableField<CarOpLogRecord, Boolean> CLIENT_TYPE = createField("client_type", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "操作渠道：1:ios，2:android，3:运营后台");

    /**
     * The column <code>jay.car_op_log.create_time</code>. 开始时间
     */
    public final TableField<CarOpLogRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "开始时间");

    /**
     * The column <code>jay.car_op_log.update_time</code>. 结束时间
     */
    public final TableField<CarOpLogRecord, Timestamp> UPDATE_TIME = createField("update_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "结束时间");

    /**
     * The column <code>jay.car_op_log.channel_type</code>. 下发方式
     */
    public final TableField<CarOpLogRecord, Boolean> CHANNEL_TYPE = createField("channel_type", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "下发方式");

    /**
     * The column <code>jay.car_op_log.car_status</code>. 车辆使用状态
     */
    public final TableField<CarOpLogRecord, Boolean> CAR_STATUS = createField("car_status", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "车辆使用状态");

    /**
     * The column <code>jay.car_op_log.snap_shot</code>. 车辆快照信息，json格式
     */
    public final TableField<CarOpLogRecord, String> SNAP_SHOT = createField("snap_shot", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "车辆快照信息，json格式");

    /**
     * The column <code>jay.car_op_log.fail_reason</code>. 失败原因,允许多个原因同时存在:(1,"ACC处于打开状态"),(2,"ACC处于关闭状态"),(3,"车门处于打开状态"),(4,"车门处于关闭状态"),(5,"车窗处于打开状态"),(6,"车窗处于关闭状态"),(7,"继电器处于打开状态"),(8,"继电器处于关闭状态"),(9,"车锁处于打开状态"),(10,"车锁处于关闭状态"),(11,"车灯处于打开状态"),(12,"车灯处于关闭状态");
     */
    public final TableField<CarOpLogRecord, String> FAIL_REASON = createField("fail_reason", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "失败原因,允许多个原因同时存在:(1,\"ACC处于打开状态\"),(2,\"ACC处于关闭状态\"),(3,\"车门处于打开状态\"),(4,\"车门处于关闭状态\"),(5,\"车窗处于打开状态\"),(6,\"车窗处于关闭状态\"),(7,\"继电器处于打开状态\"),(8,\"继电器处于关闭状态\"),(9,\"车锁处于打开状态\"),(10,\"车锁处于关闭状态\"),(11,\"车灯处于打开状态\"),(12,\"车灯处于关闭状态\");");

    /**
     * The column <code>jay.car_op_log.op_id</code>. 操作id
     */
    public final TableField<CarOpLogRecord, Long> OP_ID = createField("op_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "操作id");

    /**
     * The column <code>jay.car_op_log.order_sn</code>. 订单编号
     */
    public final TableField<CarOpLogRecord, String> ORDER_SN = createField("order_sn", org.jooq.impl.SQLDataType.CHAR(21).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.CHAR)), this, "订单编号");

    /**
     * Create a <code>jay.car_op_log</code> table reference
     */
    public CarOpLog() {
        this(DSL.name("car_op_log"), null);
    }

    /**
     * Create an aliased <code>jay.car_op_log</code> table reference
     */
    public CarOpLog(String alias) {
        this(DSL.name(alias), CAR_OP_LOG);
    }

    /**
     * Create an aliased <code>jay.car_op_log</code> table reference
     */
    public CarOpLog(Name alias) {
        this(alias, CAR_OP_LOG);
    }

    private CarOpLog(Name alias, Table<CarOpLogRecord> aliased) {
        this(alias, aliased, null);
    }

    private CarOpLog(Name alias, Table<CarOpLogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "车辆操作记录");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Jay.JAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CAR_OP_LOG_IDX_CAR, Indexes.CAR_OP_LOG_IDX_OP_ID, Indexes.CAR_OP_LOG_IDX_USER, Indexes.CAR_OP_LOG_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CarOpLogRecord, Long> getIdentity() {
        return Keys.IDENTITY_CAR_OP_LOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CarOpLogRecord> getPrimaryKey() {
        return Keys.KEY_CAR_OP_LOG_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CarOpLogRecord>> getKeys() {
        return Arrays.<UniqueKey<CarOpLogRecord>>asList(Keys.KEY_CAR_OP_LOG_PRIMARY, Keys.KEY_CAR_OP_LOG_IDX_OP_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLog as(String alias) {
        return new CarOpLog(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CarOpLog as(Name alias) {
        return new CarOpLog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CarOpLog rename(String name) {
        return new CarOpLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CarOpLog rename(Name name) {
        return new CarOpLog(name, null);
    }
}
/*
 * This file is generated by jOOQ.
*/
package com.example.domain.jooq;


import com.example.domain.jooq.tables.CarOpLog;
import com.example.domain.jooq.tables.JobExecutionLog;
import com.example.domain.jooq.tables.JobStatusTraceLog;
import com.example.domain.jooq.tables.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Jay extends SchemaImpl {

    private static final long serialVersionUID = -1181177910;

    /**
     * The reference instance of <code>jay</code>
     */
    public static final Jay JAY = new Jay();

    /**
     * 车辆操作记录
     */
    public final CarOpLog CAR_OP_LOG = com.example.domain.jooq.tables.CarOpLog.CAR_OP_LOG;

    /**
     * The table <code>jay.JOB_EXECUTION_LOG</code>.
     */
    public final JobExecutionLog JOB_EXECUTION_LOG = com.example.domain.jooq.tables.JobExecutionLog.JOB_EXECUTION_LOG;

    /**
     * The table <code>jay.JOB_STATUS_TRACE_LOG</code>.
     */
    public final JobStatusTraceLog JOB_STATUS_TRACE_LOG = com.example.domain.jooq.tables.JobStatusTraceLog.JOB_STATUS_TRACE_LOG;

    /**
     * The table <code>jay.user</code>.
     */
    public final User USER = com.example.domain.jooq.tables.User.USER;

    /**
     * No further instances allowed
     */
    private Jay() {
        super("jay", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            CarOpLog.CAR_OP_LOG,
            JobExecutionLog.JOB_EXECUTION_LOG,
            JobStatusTraceLog.JOB_STATUS_TRACE_LOG,
            User.USER);
    }
}
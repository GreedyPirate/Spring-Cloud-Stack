package com.ttyc.mq.common.annotations;

import java.lang.annotation.*;

/**
 * 不需要封装返回体，用于下载
 *
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/6/26
 */
@Documented
@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoWrapper {
}

package com.anmi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wangjue on 2017/7/21.
 */
@Target({ ElementType.FIELD})
@Retention(RUNTIME)
@Documented
public @interface ManyToOne {
    String primaryKey();
    String foreignKey();
    boolean cascade() default false; //是否级联查询
    boolean fetch() default false; //是否延迟查询
}

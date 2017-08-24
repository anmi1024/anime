package com.anmi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wangjue on 2017/7/19.
 */
@Target({ ElementType.TYPE})
@Retention(RUNTIME)
@Documented
public @interface Entity {
    String value();
}

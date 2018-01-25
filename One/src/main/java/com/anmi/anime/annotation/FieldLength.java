package com.anmi.anime.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wangjue on 2017/6/19.
 * the field itself length
 */
@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD })
@Retention(RUNTIME)
@Documented
public @interface FieldLength {
    boolean has() default true;
    int value() default 32;
}

package com.anmi.anime.define;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wangjue on 2017/6/21.
 */
@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Documented
public @interface CutLength {
    int offset() default 0;
    int len() default 0;
}

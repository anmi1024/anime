package com.anmi.anime.annotation;

import java.lang.annotation.*;

/**
 * Created by wangjue on 2017/6/30.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoTrim {
}

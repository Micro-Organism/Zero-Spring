package com.zero.spring.annotaions.common.annotations;

import java.lang.annotation.*;

/**
 * compute the executed time for the method
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RequestTime {

}

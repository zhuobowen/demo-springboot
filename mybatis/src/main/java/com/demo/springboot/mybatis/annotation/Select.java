package com.demo.springboot.mybatis.annotation;

import java.lang.annotation.*;

/**
 * 查询
 * @author xmrbi
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {

    String[] value();
    
}

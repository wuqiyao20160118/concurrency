package com.example.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记 线程不安全 的类或者写法
 */
@Target(ElementType.TYPE)  // @Target:注解的作用目标  @Target(ElementType.TYPE): 接口、类、枚举
@Retention(RetentionPolicy.SOURCE)  //注解仅存在于源码中，在class字节码文件中不包含
public @interface NotThreadSafe {

    String value() default  "";
}

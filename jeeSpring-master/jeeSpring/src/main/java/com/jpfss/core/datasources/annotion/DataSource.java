package com.jpfss.core.datasources.annotion;

import java.lang.annotation.*;

/**
 * @Description:多数据源切换注解
 * @Date: Created in 20:43 2018/1/15
 * @Author: jpfss
 * @Modified:jpfss
 * @version:V1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DataSource {
    String name() default "";
}

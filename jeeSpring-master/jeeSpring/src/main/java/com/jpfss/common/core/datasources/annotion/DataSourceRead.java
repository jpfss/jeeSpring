package com.jpfss.common.core.datasources.annotion;

import com.jpfss.common.core.datasources.DataSourceTypeEnmu;

import java.lang.annotation.*;

/**
 * @Description:只读数据源注解
 * @Date: Created in 20:43 2018/1/15
 * @Author: jpfss
 * @Modified:jpfss
 * @version:V1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DataSourceRead {
    DataSourceTypeEnmu type() default  DataSourceTypeEnmu.WRITE;
}

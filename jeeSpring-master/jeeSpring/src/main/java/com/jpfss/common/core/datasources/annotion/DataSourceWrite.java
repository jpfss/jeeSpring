package com.jpfss.common.core.datasources.annotion;

import com.jpfss.common.core.datasources.DataSourceTypeEnmu;

import java.lang.annotation.*;

/**
 * @ProjectName: jeeSpring
 * @Package: com.jpfss.common.core.datasources.annotion
 * @ClassName: DataSourceWrite
 * @Description:
 * @Author: jpfss
 * @CreateDate: 2018/1/17 21:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/1/17 21:21
 * @UpdateRemark: 写数据源注解
 * @Version: 1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSourceWrite {
    DataSourceTypeEnmu type() default  DataSourceTypeEnmu.READ;
}

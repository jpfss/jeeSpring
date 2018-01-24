package com.jpfss.common.datasources;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ProjectName: jeeSpring
 * @Package: com.jpfss.common.datasources
 * @ClassName: DynamicDataSource
 * @Description: 继承Spring的类查询数据源
 * @Author: jpfss
 * @CreateDate: 2018/1/16 21:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/1/16 21:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    /**
     * 切换数据源方法
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }
}

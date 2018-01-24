package com.jpfss.common.datasources;

/**
 * @ProjectName: jeeSpring
 * @Package: com.jpfss.common.datasources
 * @ClassName: DataSourceTypeEnmu
 * @Description: 数据源类型枚举类
 * @Author: jpfss
 * @CreateDate: 2018/1/16 21:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/1/16 21:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum DataSourceTypeEnmu {

    WRITE("write"), READ("read");
    private String dataSourceKey;

    DataSourceTypeEnmu(String dataSourceKey) {
        this.dataSourceKey = dataSourceKey;
    }

    public String getDataSourceKey() {
        return dataSourceKey;
    }
}

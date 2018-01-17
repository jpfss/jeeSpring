package com.jpfss.core.datasources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ProjectName: jeeSpring
 * @Package: com.jpfss.core.datasources
 * @ClassName: DataSourceContextHolder
 * @Description: 切换数据源辅助类
 * @Author: jpfss
 * @CreateDate: 2018/1/17 20:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/1/17 20:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DataSourceContextHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceContextHolder.class);
    // 线程本地变量副本，保证线程安全
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置数据源类型
     */
    public static void setDataSourceType(String dataSourceTtpe){
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("==============切换数据源，类型："+dataSourceTtpe+"================");
            contextHolder.set(dataSourceTtpe);
        }
    }

    /**
     * 获取数据源类型
     * @return
     */
    public static String getDataSourceType(){
        return contextHolder.get();
    }

    /**
     * 清楚数据源
     */
    public static void cleanDataSource(){
        contextHolder.remove();
    }


}

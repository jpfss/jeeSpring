package com.jpfss.core.datasources.aspect;

import com.jpfss.core.datasources.DataSourceContextHolder;
import com.jpfss.core.datasources.DataSourceTypeEnmu;
import com.jpfss.core.datasources.annotion.DataSourceRead;
import com.jpfss.core.datasources.annotion.DataSourceWrite;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ProjectName: jeeSpring
 * @Package: com.jpfss.core.datasources.aspect
 * @ClassName: DynamicDataSourceAspect
 * @Description: AOP利用动态代理自动切换数据源
 * @Author: jpfss
 * @CreateDate: 2018/1/17 20:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/1/17 20:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Aspect
@Component
public class DynamicDataSourceAspect implements Ordered {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /*拦截含有读数据源该注解的方法*/
    @Pointcut("@annotation(com.jpfss.core.datasources.annotion.DataSourceRead)")
    public void readMethodPointcut() {
    }


    /**
     * 有都数据源注解就用读数据源，没有的话默认用写数据源
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around("readMethodPointcut()")
    public Object switchDataSourceToRead(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DataSourceRead dataSourceRead = method.getAnnotation(DataSourceRead.class);
        //如果没有注解，默认设置为Write
        if (null == dataSourceRead) {
            DataSourceContextHolder.setDataSourceType(DataSourceTypeEnmu.valueOf("WRITE").getDataSourceKey());
            logger.debug("set datasource is " + DataSourceTypeEnmu.valueOf("WRITE").getDataSourceKey());
        } else {
            DataSourceContextHolder.setDataSourceType(dataSourceRead.type().getDataSourceKey());
            logger.debug("set datasource is " + dataSourceRead.type().getDataSourceKey());
        }

        try {
            return proceedingJoinPoint.proceed();
        } finally {
            DataSourceContextHolder.cleanDataSource();
            logger.debug("clean DataSource!");
        }

    }

    /*拦截含有xie数据源该注解的方法*/
    @Pointcut("@annotation(com.jpfss.core.datasources.annotion.DataSourceWrite)")
    public void writeMethodPointcut() {
    }

    /**
     * 注解和默认都设置为
     * @param proceedingJoinPoint
     * @return
     */
    @Around("writeMethodPointcut()")
    public Object switchDataSourceToWirte(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DataSourceWrite dataSourceWrite = method.getAnnotation(DataSourceWrite.class);
        //不管写数据源是否为空都设置成写数据源
        if (null == dataSourceWrite){
            DataSourceContextHolder.setDataSourceType(DataSourceTypeEnmu.valueOf("WRITE").getDataSourceKey());
            logger.debug("set datasource is " + DataSourceTypeEnmu.valueOf("WRITE").getDataSourceKey());
        }else{
            DataSourceContextHolder.setDataSourceType(dataSourceWrite.type().getDataSourceKey());
            logger.debug("set datasource is " + dataSourceWrite.type().getDataSourceKey());
        }
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            DataSourceContextHolder.cleanDataSource();
            logger.debug("clean DataSource!");
        }

    }

    /**
     * 执行等级，越小越先执行
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }
}

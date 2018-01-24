package com.jpfss.common.base.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * 通用枚举处理类
 * @param <T>
 */
public class BaseEntity<T extends Model> extends Model<T>{

    protected  Serializable pkVal(){return  null;}

}

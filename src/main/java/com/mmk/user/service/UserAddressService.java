package com.mmk.user.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.user.model.UserAddress;
import com.mmk.user.condition.UserAddressCondition;

/**
* UserAddressService: 用户地址 业务服务层接口
*2017-04-08 08:36:43
*@author codegenerator
*@version 1.0
*/
public interface UserAddressService extends BaseService<UserAddress, Long> {
    /**
     * 生成的列表分页查询方法
     * @param userAddressCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author codegenerator
     * 
     */
    Page<UserAddress> list(UserAddressCondition userAddressCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  userAddress 查询类
     * @return 查询的结果集
     * @author codegenerator
     * 
     */
    public List<UserAddress> list(UserAddressCondition userAddress);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field UserAddress 中的某个字段
     * @param value 字段的值
     * @return UserAddress 返回符合条件的结果，如果没有返回null
     * @author codegenerator
     * 
     * 
     */
    UserAddress findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field UserAddress中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author codegenerator
     * 
     * 
     */
    List<UserAddress> findAllBy(String field,Object value);
}
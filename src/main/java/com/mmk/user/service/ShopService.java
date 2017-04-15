package com.mmk.user.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.user.model.Shop;
import com.mmk.user.condition.ShopCondition;

/**
* ShopService: 用户店铺 业务服务层接口
*2017-04-15 12:34:53
*@author codegenerator
*@version 1.0
*/
public interface ShopService extends BaseService<Shop, Long> {
    /**
     * 生成的列表分页查询方法
     * @param shopCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author codegenerator
     * 
     */
    Page<Shop> list(ShopCondition shopCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  shop 查询类
     * @return 查询的结果集
     * @author codegenerator
     * 
     */
    public List<Shop> list(ShopCondition shop);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Shop 中的某个字段
     * @param value 字段的值
     * @return Shop 返回符合条件的结果，如果没有返回null
     * @author codegenerator
     * 
     * 
     */
    Shop findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Shop中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author codegenerator
     * 
     * 
     */
    List<Shop> findAllBy(String field,Object value);
}
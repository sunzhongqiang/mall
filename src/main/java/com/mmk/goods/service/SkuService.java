package com.mmk.goods.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.goods.model.Sku;
import com.mmk.goods.condition.SkuCondition;

/**
* SkuService: 商品SKU 业务服务层接口
*2017-04-18 11:24:46
*@author codegenerator
*@version 1.0
*/
public interface SkuService extends BaseService<Sku, Long> {
    /**
     * 生成的列表分页查询方法
     * @param skuCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author codegenerator
     * 
     */
    Page<Sku> list(SkuCondition skuCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  sku 查询类
     * @return 查询的结果集
     * @author codegenerator
     * 
     */
    public List<Sku> list(SkuCondition sku);

    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品id
     * @return 符合条件的所有对象
     * @author codegenerator
     * 
     */
    List<Sku> findAllByGoodsId(Long goodsId);
    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author codegenerator
     * 
     */
    Page<Sku> findAllByGoodsId(Long goodsId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Sku 中的某个字段
     * @param value 字段的值
     * @return Sku 返回符合条件的结果，如果没有返回null
     * @author codegenerator
     * 
     * 
     */
    Sku findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Sku中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author codegenerator
     * 
     * 
     */
    List<Sku> findAllBy(String field,Object value);
}
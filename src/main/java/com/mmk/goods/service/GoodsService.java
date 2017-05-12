package com.mmk.goods.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.goods.model.Goods;
import com.mmk.goods.condition.GoodsCondition;

/**
* GoodsService: 商品 业务服务层接口
*2017-04-17 17:45:46
*@author sunzhongqiang
*@version 1.0
*/
public interface GoodsService extends BaseService<Goods, Long> {
    /**
     * 生成的列表分页查询方法
     * @param goodsCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author sunzhongqiang
     * 
     */
    Page<Goods> list(GoodsCondition goodsCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  goods 查询类
     * @return 查询的结果集
     * @author sunzhongqiang
     * 
     */
    public List<Goods> list(GoodsCondition goods);

    /**
     * 根据字段获取所有符合的记录
     * @param userId 用户
     * @return 符合条件的所有对象
     * @author sunzhongqiang
     * 
     */
    List<Goods> findAllByUserId(Long userId);
    /**
     * 根据字段获取所有符合的记录
     * @param userId 用户
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author sunzhongqiang
     * 
     */
    Page<Goods> findAllByUserId(Long userId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Goods 中的某个字段
     * @param value 字段的值
     * @return Goods 返回符合条件的结果，如果没有返回null
     * @author sunzhongqiang
     * 
     * 
     */
    Goods findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Goods中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author sunzhongqiang
     * 
     * 
     */
    List<Goods> findAllBy(String field,Object value);
    
    /**
     * 更加用户和分类以及商品信息进行获取用户的商品信息
     * @param userId 用户id
     * @param categoryId 分类Id
     * @param goodsCondition 商品信息
     * @param pageable 分页信息
     * @return 商品分页数据
     */
	Page<Goods> list(Long userId, Long categoryId, GoodsCondition goodsCondition, Pageable pageable);
}
package com.mmk.goods.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.goods.model.GoodsCategory;
import com.mmk.goods.condition.GoodsCategoryCondition;

/**
* GoodsCategoryService: 商品分类 业务服务层接口
*2017-04-17 17:46:40
*@author sunzhongqiang
*@version 1.0
*/
public interface GoodsCategoryService extends BaseService<GoodsCategory, Long> {
    /**
     * 生成的列表分页查询方法
     * @param goodsCategoryCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author sunzhongqiang
     * 
     */
    Page<GoodsCategory> list(GoodsCategoryCondition goodsCategoryCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  goodsCategory 查询类
     * @return 查询的结果集
     * @author sunzhongqiang
     * 
     */
    public List<GoodsCategory> list(GoodsCategoryCondition goodsCategory);

    /**
     * 根据字段获取所有符合的记录
     * @param parentId 父分类的id
     * @return 符合条件的所有对象
     * @author sunzhongqiang
     * 
     */
    List<GoodsCategory> findAllByParentId(Long parentId);
    /**
     * 根据字段获取所有符合的记录
     * @param parentId 父分类的id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author sunzhongqiang
     * 
     */
    Page<GoodsCategory> findAllByParentId(Long parentId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field GoodsCategory 中的某个字段
     * @param value 字段的值
     * @return GoodsCategory 返回符合条件的结果，如果没有返回null
     * @author sunzhongqiang
     * 
     * 
     */
    GoodsCategory findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field GoodsCategory中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author sunzhongqiang
     * 
     * 
     */
    List<GoodsCategory> findAllBy(String field,Object value);
}
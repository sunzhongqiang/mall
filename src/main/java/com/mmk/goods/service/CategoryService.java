package com.mmk.goods.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.goods.model.Category;
import com.mmk.goods.condition.CategoryCondition;

/**
* CategoryService: 商品分类 业务服务层接口
*2017-04-17 18:14:42
*@author codegene
*@version 1.0
*/
public interface CategoryService extends BaseService<Category, Long> {
    /**
     * 生成的列表分页查询方法
     * @param categoryCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author codegene
     * 
     */
    Page<Category> list(CategoryCondition categoryCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  category 查询类
     * @return 查询的结果集
     * @author codegene
     * 
     */
    public List<Category> list(CategoryCondition category);

    /**
     * 根据字段获取所有符合的记录
     * @param parentId 父分类的id
     * @return 符合条件的所有对象
     * @author codegene
     * 
     */
    List<Category> findAllByParentId(Long parentId);
    /**
     * 根据字段获取所有符合的记录
     * @param parentId 父分类的id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author codegene
     * 
     */
    Page<Category> findAllByParentId(Long parentId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Category 中的某个字段
     * @param value 字段的值
     * @return Category 返回符合条件的结果，如果没有返回null
     * @author codegene
     * 
     * 
     */
    Category findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Category中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author codegene
     * 
     * 
     */
    List<Category> findAllBy(String field,Object value);
}
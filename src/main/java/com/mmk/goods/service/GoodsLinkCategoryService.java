package com.mmk.goods.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.goods.model.Goods;
import com.mmk.goods.model.GoodsLinkCategory;
import com.mmk.goods.condition.GoodsCondition;
import com.mmk.goods.condition.GoodsLinkCategoryCondition;

/**
* GoodsLinkCategoryService: 商品分类关联表 业务服务层接口
*2017-05-10 11:48:45
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
public interface GoodsLinkCategoryService extends BaseService<GoodsLinkCategory, Long> {
    /**
     * 生成的列表分页查询方法
     * @param goodsLinkCategoryCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<GoodsLinkCategory> list(GoodsLinkCategoryCondition goodsLinkCategoryCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  goodsLinkCategory 查询类
     * @return 查询的结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    public List<GoodsLinkCategory> list(GoodsLinkCategoryCondition goodsLinkCategory);

    /**
     * 根据字段获取所有符合的记录
     * @param categoryId 分类主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<GoodsLinkCategory> findAllByCategoryId(Long categoryId);
    /**
     * 根据字段获取所有符合的记录
     * @param categoryId 分类主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<GoodsLinkCategory> findAllByCategoryId(Long categoryId, Pageable pageable);
    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<GoodsLinkCategory> findAllByGoodsId(Long goodsId);
    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<GoodsLinkCategory> findAllByGoodsId(Long goodsId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field GoodsLinkCategory 中的某个字段
     * @param value 字段的值
     * @return GoodsLinkCategory 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    GoodsLinkCategory findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field GoodsLinkCategory中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<GoodsLinkCategory> findAllBy(String field,Object value);
    
    /**
     * 根据字段获取所有符合的记录
     * @param userId 用户主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhognqiang
     * 
     */
    List<GoodsLinkCategory> findAllByUserId(Long userId);
    /**
     * 根据字段获取所有符合的记录
     * @param userId 用户主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhognqiang
     * 
     */
    Page<GoodsLinkCategory> findAllByUserId(Long userId, Pageable pageable);

    /**
     * 根据用户主键和商品主键获取当前商品的关联分类
     * @param userId
     * @param goodsId
     * @return
     */
	List<GoodsLinkCategory> findAllByUserAndGoodsId(Long userId, Long goodsId);

	/**
	 * 根据用户，商品，分类或者三者的管理
	 * @param userId 用户
	 * @param goodsId 商品
	 * @param categoryId 分类
	 * @return 符合条件的结果
	 */
	GoodsLinkCategory findBy(Long userId, Long goodsId, Long categoryId);

}
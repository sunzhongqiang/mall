package com.mmk.goods.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.goods.model.GoodsImg;
import com.mmk.goods.condition.GoodsImgCondition;

/**
* GoodsImgService: 商品图片 业务服务层接口
*2017-04-24 08:56:29
*@author codegenerator
*@version 1.0
*/
public interface GoodsImgService extends BaseService<GoodsImg, Long> {
    /**
     * 生成的列表分页查询方法
     * @param goodsImgCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author codegenerator
     * 
     */
    Page<GoodsImg> list(GoodsImgCondition goodsImgCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  goodsImg 查询类
     * @return 查询的结果集
     * @author codegenerator
     * 
     */
    public List<GoodsImg> list(GoodsImgCondition goodsImg);

    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品ID
     * @return 符合条件的所有对象
     * @author codegenerator
     * 
     */
    List<GoodsImg> findAllByGoodsId(Long goodsId);
    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author codegenerator
     * 
     */
    Page<GoodsImg> findAllByGoodsId(Long goodsId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field GoodsImg 中的某个字段
     * @param value 字段的值
     * @return GoodsImg 返回符合条件的结果，如果没有返回null
     * @author codegenerator
     * 
     * 
     */
    GoodsImg findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field GoodsImg中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author codegenerator
     * 
     * 
     */
    List<GoodsImg> findAllBy(String field,Object value);
    
    /**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field GoodsImg中的某个字段
	 * @param value 字段的值
	 * @return 返回符合条件的所有结果
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	List<GoodsImg> findByGoodsId(Long id);
}
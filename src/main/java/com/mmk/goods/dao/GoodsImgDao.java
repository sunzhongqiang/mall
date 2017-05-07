/*
 * 
 *  GoodsImgDao 创建于 2017-04-24 08:56:29 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.goods.condition.GoodsImgCondition;
import com.mmk.goods.model.GoodsImg;
/**
* GoodsImgDao:商品图片 数据持久层接口
* @author codegenerator
* @version 1.0
*/
public interface GoodsImgDao extends SpringDataQueryDao<GoodsImg>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsImg 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     * 
     */
    Page<GoodsImg> list(GoodsImgCondition goodsImg,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param goodsImg 查询类
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     */
    List<GoodsImg> list(GoodsImgCondition goodsImg);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param goodsImg GoodsImg类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(GoodsImgCondition goodsImg,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field GoodsImg 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author codegenerator
     * 
     * 
     */
    GoodsImg findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field GoodsImg 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author codegenerator
     * 
     * 
     */
    List<GoodsImg> findAllBy(String field,Object value);
    
    
    /**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field  GoodsImg 中的某个字段
	 * @param value 字段对应的值
	 * @return 返回符合条件的所有结果
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	List<GoodsImg> findByGoodsId(Long id);
    
    

}
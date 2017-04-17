/*
 * 
 *  GoodsCategoryDao 创建于 2017-04-17 17:46:40 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.goods.condition.GoodsCategoryCondition;
import com.mmk.goods.model.GoodsCategory;
/**
* GoodsCategoryDao:商品分类 数据持久层接口
* @author sunzhongqiang
* @version 1.0
*/
public interface GoodsCategoryDao extends SpringDataQueryDao<GoodsCategory>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsCategory 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author sunzhongqiang
     * 
     * 
     */
    Page<GoodsCategory> list(GoodsCategoryCondition goodsCategory,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param goodsCategory 查询类
     * @return 符合条件的查询结果集
     * @author sunzhongqiang
     * 
     */
    List<GoodsCategory> list(GoodsCategoryCondition goodsCategory);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param goodsCategory GoodsCategory类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author sunzhongqiang
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(GoodsCategoryCondition goodsCategory,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field GoodsCategory 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author sunzhongqiang
     * 
     * 
     */
    GoodsCategory findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field GoodsCategory 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author sunzhongqiang
     * 
     * 
     */
    List<GoodsCategory> findAllBy(String field,Object value);
    
    

}
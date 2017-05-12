/*
 * 
 *  GoodsLinkCategoryDaoImpl 创建于 2017-05-10 11:48:45 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mmk.goods.model.GoodsLinkCategory;
import com.mmk.goods.dao.GoodsLinkCategoryDao;

import com.mmk.goods.condition.GoodsLinkCategoryCondition;



/**
* GoodsLinkCategoryDaoImpl: 商品分类关联表 数据持久层接口实现
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
@Repository
public class GoodsLinkCategoryDaoImpl extends SpringDataQueryDaoImpl<GoodsLinkCategory> implements GoodsLinkCategoryDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public GoodsLinkCategoryDaoImpl(){
        super(GoodsLinkCategory.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsLinkCategoryCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    @Override 
    public Page<GoodsLinkCategory> list(GoodsLinkCategoryCondition goodsLinkCategoryCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from GoodsLinkCategory model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(goodsLinkCategoryCondition.getCategoryId()!=null){
            sb.append(" and model.categoryId = :categoryId ");
            params.put("categoryId",goodsLinkCategoryCondition.getCategoryId());
        }
        if(goodsLinkCategoryCondition.getGoodsId()!=null){
            sb.append(" and model.goodsId = :goodsId ");
            params.put("goodsId",goodsLinkCategoryCondition.getGoodsId());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<GoodsLinkCategory> list(GoodsLinkCategoryCondition goodsLinkCategoryCondition){
        StringBuffer sb=new StringBuffer("select model from GoodsLinkCategory model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(goodsLinkCategoryCondition.getCategoryId()!=null){
            sb.append(" and model.categoryId = :categoryId ");
            params.put("categoryId",goodsLinkCategoryCondition.getCategoryId());
        }
        if(goodsLinkCategoryCondition.getGoodsId()!=null){
            sb.append(" and model.goodsId = :goodsId ");
            params.put("goodsId",goodsLinkCategoryCondition.getGoodsId());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(GoodsLinkCategoryCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,category_id,goods_id from goods_link_category  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getCategoryId()!=null){
            sb.append(" and category_id = ?2 ");
            params.put(2,condition.getCategoryId());
        }
        if(condition.getGoodsId()!=null){
            sb.append(" and goods_id = ?3 ");
            params.put(3,condition.getGoodsId());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public GoodsLinkCategory findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsLinkCategory model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<GoodsLinkCategory> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<GoodsLinkCategory> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsLinkCategory model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}
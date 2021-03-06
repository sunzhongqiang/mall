/*
 * 
 *  GoodsImgDaoImpl 创建于 2017-04-24 08:56:29 版权归作者和作者当前组织所有
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

import com.mmk.goods.model.GoodsImg;
import com.mmk.goods.dao.GoodsImgDao;

import com.mmk.goods.condition.GoodsImgCondition;



/**
* GoodsImgDaoImpl: 商品图片 数据持久层接口实现
*@author codegenerator
*@version 1.0
*
*/
@Repository
public class GoodsImgDaoImpl extends SpringDataQueryDaoImpl<GoodsImg> implements GoodsImgDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public GoodsImgDaoImpl(){
        super(GoodsImg.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsImgCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     */
    @Override 
    public Page<GoodsImg> list(GoodsImgCondition goodsImgCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from GoodsImg model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<GoodsImg> list(GoodsImgCondition goodsImgCondition){
        StringBuffer sb=new StringBuffer("select model from GoodsImg model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(GoodsImgCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,goods_id,original_img,small_thumb_img,big_thumb_img from goods_img  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public GoodsImg findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsImg model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<GoodsImg> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<GoodsImg> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsImg model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    @Override
	public List<GoodsImg> findByGoodsId(Long goodsId) {
		StringBuffer sb = new StringBuffer("select model from GoodsImg model  where model.goodsId");
		sb.append(" = :goodsId ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("goodsId", goodsId);
		return queryByJpql(sb.toString(), params);
	}
    
    
}
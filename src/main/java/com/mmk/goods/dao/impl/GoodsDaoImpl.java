/*
 * 
 *  GoodsDaoImpl 创建于 2017-04-17 17:45:46 版权归作者和作者当前组织所有
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

import com.mmk.goods.model.Goods;
import com.mmk.goods.dao.GoodsDao;

import com.mmk.goods.condition.GoodsCondition;



/**
* GoodsDaoImpl: 商品 数据持久层接口实现
*@author sunzhongqiang
*@version 1.0
*
*/
@Repository
public class GoodsDaoImpl extends SpringDataQueryDaoImpl<Goods> implements GoodsDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public GoodsDaoImpl(){
        super(Goods.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author sunzhongqiang
     * 
     */
    @Override 
    public Page<Goods> list(GoodsCondition goodsCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Goods model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(goodsCondition.getTitle())){
            sb.append(" and model.title like :title ");
            params.put("title","%"+goodsCondition.getTitle()+"%");
        }
        if(goodsCondition.getPrice()!=null){
            sb.append(" and model.price = :price ");
            params.put("price",goodsCondition.getPrice());
        }
        if(goodsCondition.getNum()!=null){
            sb.append(" and model.num = :num ");
            params.put("num",goodsCondition.getNum());
        }
        if(StringUtils.isNotBlank(goodsCondition.getCode())){
            sb.append(" and model.code = :code ");
            params.put("code",goodsCondition.getCode());
        }
        if(StringUtils.isNotBlank(goodsCondition.getBarcode())){
            sb.append(" and model.barcode = :barcode ");
            params.put("barcode",goodsCondition.getBarcode());
        }
        if(goodsCondition.getIsOnsale()!=null){
            sb.append(" and model.isOnsale = :isOnsale ");
            params.put("isOnsale",goodsCondition.getIsOnsale());
        }
        if(goodsCondition.getCreated()!=null){
            sb.append(" and model.created = :created ");
            params.put("created",goodsCondition.getCreated());
        }
        if(goodsCondition.getUserId()!=null){
            sb.append(" and model.userId = :userId ");
            params.put("userId",goodsCondition.getUserId());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Goods> list(GoodsCondition goodsCondition){
        StringBuffer sb=new StringBuffer("select model from Goods model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(goodsCondition.getTitle())){
            sb.append(" and model.title like :title ");
            params.put("title","%"+goodsCondition.getTitle()+"%");
        }
        if(goodsCondition.getPrice()!=null){
            sb.append(" and model.price = :price ");
            params.put("price",goodsCondition.getPrice());
        }
        if(goodsCondition.getNum()!=null){
            sb.append(" and model.num = :num ");
            params.put("num",goodsCondition.getNum());
        }
        if(StringUtils.isNotBlank(goodsCondition.getCode())){
            sb.append(" and model.code = :code ");
            params.put("code",goodsCondition.getCode());
        }
        if(StringUtils.isNotBlank(goodsCondition.getBarcode())){
            sb.append(" and model.barcode = :barcode ");
            params.put("barcode",goodsCondition.getBarcode());
        }
        if(goodsCondition.getIsOnsale()!=null){
            sb.append(" and model.isOnsale = :isOnsale ");
            params.put("isOnsale",goodsCondition.getIsOnsale());
        }
        if(goodsCondition.getCreated()!=null){
            sb.append(" and model.created = :created ");
            params.put("created",goodsCondition.getCreated());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(GoodsCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,user_id,title,price,num,code,barcode,description,original_price,promote_price,saled_number,thumb,main_img,original_img,is_onsale,created,modified from goods  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(StringUtils.isNotBlank(condition.getTitle())){
            sb.append(" and title like ?3 ");
            params.put(3,"%"+condition.getTitle()+"%");
        }
        if(condition.getPrice()!=null){
            sb.append(" and price = ?4 ");
            params.put(4,condition.getPrice());
        }
        if(condition.getNum()!=null){
            sb.append(" and num = ?5 ");
            params.put(5,condition.getNum());
        }
        if(StringUtils.isNotBlank(condition.getCode())){
            sb.append(" and code = ?6 ");
            params.put(6,condition.getCode());
        }
        if(StringUtils.isNotBlank(condition.getBarcode())){
            sb.append(" and barcode = ?7 ");
            params.put(7,condition.getBarcode());
        }
        if(condition.getIsOnsale()!=null){
            sb.append(" and is_onsale = ?15 ");
            params.put(15,condition.getIsOnsale());
        }
        if(condition.getCreated()!=null){
            sb.append(" and created = ?16 ");
            params.put(16,condition.getCreated());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Goods findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Goods model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Goods> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Goods> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Goods model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public Page<Goods> listByUserIdAndCategory(Long userId, Long categoryId, GoodsCondition goodsCondition,
			Pageable pageable) {
		StringBuffer sb=new StringBuffer("select model from Goods model ,GoodsLinkCategory link  where model.id = link.goodsId and  link.userId = :userId  ");
        Map<String,Object> params = new HashMap<String,Object>();
        
        params.put("userId", userId);
        if(categoryId != null){
        	sb.append(" and link.categoryId = :categoryId ");
        	params.put("categoryId", categoryId);
        }
        if(StringUtils.isNotBlank(goodsCondition.getTitle())){
            sb.append(" and model.title like :title ");
            params.put("title","%"+goodsCondition.getTitle()+"%");
        }
        if(goodsCondition.getPrice()!=null){
            sb.append(" and model.price = :price ");
            params.put("price",goodsCondition.getPrice());
        }
        if(goodsCondition.getNum()!=null){
            sb.append(" and model.num = :num ");
            params.put("num",goodsCondition.getNum());
        }
        if(StringUtils.isNotBlank(goodsCondition.getCode())){
            sb.append(" and model.code = :code ");
            params.put("code",goodsCondition.getCode());
        }
        if(StringUtils.isNotBlank(goodsCondition.getBarcode())){
            sb.append(" and model.barcode = :barcode ");
            params.put("barcode",goodsCondition.getBarcode());
        }
        if(goodsCondition.getIsOnsale()!=null){
            sb.append(" and model.isOnsale = :isOnsale ");
            params.put("isOnsale",goodsCondition.getIsOnsale());
        }
        if(goodsCondition.getCreated()!=null){
            sb.append(" and model.created = :created ");
            params.put("created",goodsCondition.getCreated());
        }
        if(goodsCondition.getUserId()!=null){
            sb.append(" and model.userId = :userId ");
            params.put("userId",goodsCondition.getUserId());
        }
        return queryByJpql(sb.toString(), params, pageable);
	}
    
    
}
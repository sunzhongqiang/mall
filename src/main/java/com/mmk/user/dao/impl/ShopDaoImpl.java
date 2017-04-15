/*
 * 
 *  ShopDaoImpl 创建于 2017-04-15 12:34:53 版权归作者和作者当前组织所有
 */
package com.mmk.user.dao.impl;

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

import com.mmk.user.model.Shop;
import com.mmk.user.dao.ShopDao;

import com.mmk.user.condition.ShopCondition;



/**
* ShopDaoImpl: 用户店铺 数据持久层接口实现
*@author codegenerator
*@version 1.0
*
*/
@Repository
public class ShopDaoImpl extends SpringDataQueryDaoImpl<Shop> implements ShopDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public ShopDaoImpl(){
        super(Shop.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param shopCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     */
    @Override 
    public Page<Shop> list(ShopCondition shopCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Shop model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Shop> list(ShopCondition shopCondition){
        StringBuffer sb=new StringBuffer("select model from Shop model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(ShopCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,user_id,title,status,shop_description,address from user_shop  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Shop findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Shop model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Shop> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Shop> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Shop model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}
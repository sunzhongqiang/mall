/*
 * 
 *  UserAddressDaoImpl 创建于 2017-04-08 08:36:43 版权归作者和作者当前组织所有
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

import com.mmk.user.model.UserAddress;
import com.mmk.user.dao.UserAddressDao;

import com.mmk.user.condition.UserAddressCondition;



/**
* UserAddressDaoImpl: 用户地址 数据持久层接口实现
*@author codegenerator
*@version 1.0
*
*/
@Repository
public class UserAddressDaoImpl extends SpringDataQueryDaoImpl<UserAddress> implements UserAddressDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public UserAddressDaoImpl(){
        super(UserAddress.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param userAddressCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     */
    @Override 
    public Page<UserAddress> list(UserAddressCondition userAddressCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from UserAddress model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<UserAddress> list(UserAddressCondition userAddressCondition){
        StringBuffer sb=new StringBuffer("select model from UserAddress model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(UserAddressCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,user_id,consignee,country,county_name,province,province_name,city,city_name,district,district_name,address,zipcode,telephone,mobile,type from user_address  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public UserAddress findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from UserAddress model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<UserAddress> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<UserAddress> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from UserAddress model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}
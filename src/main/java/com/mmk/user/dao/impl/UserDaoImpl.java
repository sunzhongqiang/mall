/*
 * 
 *  UserDaoImpl 创建于 2017-04-08 08:36:36 版权归作者和作者当前组织所有
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

import com.mmk.user.model.User;
import com.mmk.user.dao.UserDao;

import com.mmk.user.condition.UserCondition;



/**
* UserDaoImpl: 用户 数据持久层接口实现
*@author codegenerator
*@version 1.0
*
*/
@Repository
public class UserDaoImpl extends SpringDataQueryDaoImpl<User> implements UserDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public UserDaoImpl(){
        super(User.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param userCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     */
    @Override 
    public Page<User> list(UserCondition userCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from User model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<User> list(UserCondition userCondition){
        StringBuffer sb=new StringBuffer("select model from User model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(UserCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,username,realname,password,openid,is_seller,status,created,modified from user  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public User findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from User model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<User> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<User> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from User model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}
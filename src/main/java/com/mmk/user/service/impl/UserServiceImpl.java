package com.mmk.user.service.impl;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.user.dao.UserRepository;
import com.mmk.user.model.User;
import com.mmk.user.condition.UserCondition;
import com.mmk.user.service.UserService;
import com.mmk.user.dao.UserDao;
/**
* UserServiceImpl: 用户 业务服务层实现
* 2017-04-08 08:36:36
* @author codegenerator
* @version 1.0
*/
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private UserDao userDao;
    
    private UserRepository userRepository;
    /**
    *构造方法
    * @param userRepository 数据容器
    */
    @Autowired
    public UserServiceImpl( UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> list(UserCondition userCondition, Pageable pageable) {
        log.info("用户查询列表");
        return userDao.list(userCondition, pageable);
    }
    
    @Override
    public List<User> list(UserCondition userCondition) {
        log.info("用户查询列表无分页");
        return userDao.list(userCondition);
    }

    @Override 
    public User findBy(String field,Object value){
        log.info("用户根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return userDao.findBy(field,value);
    }
    
    @Override 
    public List<User> findAllBy(String field,Object value){
        log.info("用户根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return userDao.findAllBy(field,value);
    }
}
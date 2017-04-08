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
import com.mmk.user.dao.UserAddressRepository;
import com.mmk.user.model.UserAddress;
import com.mmk.user.condition.UserAddressCondition;
import com.mmk.user.service.UserAddressService;
import com.mmk.user.dao.UserAddressDao;
/**
* UserAddressServiceImpl: 用户地址 业务服务层实现
* 2017-04-08 08:36:43
* @author codegenerator
* @version 1.0
*/
@Service
public class UserAddressServiceImpl extends BaseServiceImpl<UserAddress, Long> implements UserAddressService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private UserAddressDao userAddressDao;
    
    private UserAddressRepository userAddressRepository;
    /**
    *构造方法
    * @param userAddressRepository 数据容器
    */
    @Autowired
    public UserAddressServiceImpl( UserAddressRepository userAddressRepository) {
        super(userAddressRepository);
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public Page<UserAddress> list(UserAddressCondition userAddressCondition, Pageable pageable) {
        log.info("用户地址查询列表");
        return userAddressDao.list(userAddressCondition, pageable);
    }
    
    @Override
    public List<UserAddress> list(UserAddressCondition userAddressCondition) {
        log.info("用户地址查询列表无分页");
        return userAddressDao.list(userAddressCondition);
    }

    @Override 
    public UserAddress findBy(String field,Object value){
        log.info("用户地址根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return userAddressDao.findBy(field,value);
    }
    
    @Override 
    public List<UserAddress> findAllBy(String field,Object value){
        log.info("用户地址根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return userAddressDao.findAllBy(field,value);
    }
}
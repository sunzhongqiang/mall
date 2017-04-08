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
import com.mmk.user.dao.ShopRepository;
import com.mmk.user.model.Shop;
import com.mmk.user.condition.ShopCondition;
import com.mmk.user.service.ShopService;
import com.mmk.user.dao.ShopDao;
/**
* ShopServiceImpl: 用户店铺 业务服务层实现
* 2017-04-08 08:37:20
* @author codegenerator
* @version 1.0
*/
@Service
public class ShopServiceImpl extends BaseServiceImpl<Shop, Long> implements ShopService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private ShopDao shopDao;
    
    private ShopRepository shopRepository;
    /**
    *构造方法
    * @param shopRepository 数据容器
    */
    @Autowired
    public ShopServiceImpl( ShopRepository shopRepository) {
        super(shopRepository);
        this.shopRepository = shopRepository;
    }

    @Override
    public Page<Shop> list(ShopCondition shopCondition, Pageable pageable) {
        log.info("用户店铺查询列表");
        return shopDao.list(shopCondition, pageable);
    }
    
    @Override
    public List<Shop> list(ShopCondition shopCondition) {
        log.info("用户店铺查询列表无分页");
        return shopDao.list(shopCondition);
    }

    @Override 
    public Shop findBy(String field,Object value){
        log.info("用户店铺根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return shopDao.findBy(field,value);
    }
    
    @Override 
    public List<Shop> findAllBy(String field,Object value){
        log.info("用户店铺根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return shopDao.findAllBy(field,value);
    }
}
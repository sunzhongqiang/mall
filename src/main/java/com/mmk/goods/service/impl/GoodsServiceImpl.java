package com.mmk.goods.service.impl;

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
import com.mmk.goods.dao.GoodsRepository;
import com.mmk.goods.model.Goods;
import com.mmk.goods.condition.GoodsCondition;
import com.mmk.goods.service.GoodsService;
import com.mmk.goods.dao.GoodsDao;
/**
* GoodsServiceImpl: 商品 业务服务层实现
* 2017-04-17 17:45:46
* @author sunzhongqiang
* @version 1.0
*/
@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods, Long> implements GoodsService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private GoodsDao goodsDao;
    
    private GoodsRepository goodsRepository;
    /**
    *构造方法
    * @param goodsRepository 数据容器
    */
    @Autowired
    public GoodsServiceImpl( GoodsRepository goodsRepository) {
        super(goodsRepository);
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Page<Goods> list(GoodsCondition goodsCondition, Pageable pageable) {
        log.info("商品查询列表");
        return goodsDao.list(goodsCondition, pageable);
    }
    
    @Override
    public List<Goods> list(GoodsCondition goodsCondition) {
        log.info("商品查询列表无分页");
        return goodsDao.list(goodsCondition);
    }

    /**
     * 根据字段获取所有符合的记录
     * @param userId 用户
     * @return 符合条件的所有对象
     */
    @Override
    public List<Goods>  findAllByUserId(Long userId){
        return goodsRepository.findAllByUserId(userId);
    }
    
     @Override
    public Page<Goods>  findAllByUserId(Long userId, Pageable pageable){
        return goodsRepository.findAllByUserId(userId,pageable);
    }
    @Override 
    public Goods findBy(String field,Object value){
        log.info("商品根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return goodsDao.findBy(field,value);
    }
    
    @Override 
    public List<Goods> findAllBy(String field,Object value){
        log.info("商品根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return goodsDao.findAllBy(field,value);
    }
}
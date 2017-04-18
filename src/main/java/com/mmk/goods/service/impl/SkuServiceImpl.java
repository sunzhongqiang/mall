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
import com.mmk.goods.dao.SkuRepository;
import com.mmk.goods.model.Sku;
import com.mmk.goods.condition.SkuCondition;
import com.mmk.goods.service.SkuService;
import com.mmk.goods.dao.SkuDao;
/**
* SkuServiceImpl: 商品SKU 业务服务层实现
* 2017-04-18 11:24:46
* @author codegenerator
* @version 1.0
*/
@Service
public class SkuServiceImpl extends BaseServiceImpl<Sku, Long> implements SkuService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private SkuDao skuDao;
    
    private SkuRepository skuRepository;
    /**
    *构造方法
    * @param skuRepository 数据容器
    */
    @Autowired
    public SkuServiceImpl( SkuRepository skuRepository) {
        super(skuRepository);
        this.skuRepository = skuRepository;
    }

    @Override
    public Page<Sku> list(SkuCondition skuCondition, Pageable pageable) {
        log.info("商品SKU查询列表");
        return skuDao.list(skuCondition, pageable);
    }
    
    @Override
    public List<Sku> list(SkuCondition skuCondition) {
        log.info("商品SKU查询列表无分页");
        return skuDao.list(skuCondition);
    }

    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品id
     * @return 符合条件的所有对象
     */
    @Override
    public List<Sku>  findAllByGoodsId(Long goodsId){
        return skuRepository.findAllByGoodsId(goodsId);
    }
    
     @Override
    public Page<Sku>  findAllByGoodsId(Long goodsId, Pageable pageable){
        return skuRepository.findAllByGoodsId(goodsId,pageable);
    }
    @Override 
    public Sku findBy(String field,Object value){
        log.info("商品SKU根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return skuDao.findBy(field,value);
    }
    
    @Override 
    public List<Sku> findAllBy(String field,Object value){
        log.info("商品SKU根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return skuDao.findAllBy(field,value);
    }
}
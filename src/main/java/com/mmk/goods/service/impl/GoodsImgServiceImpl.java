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
import com.mmk.goods.dao.GoodsImgRepository;
import com.mmk.goods.model.GoodsImg;
import com.mmk.goods.condition.GoodsImgCondition;
import com.mmk.goods.service.GoodsImgService;
import com.mmk.goods.dao.GoodsImgDao;
/**
* GoodsImgServiceImpl: 商品图片 业务服务层实现
* 2017-04-24 08:56:29
* @author codegenerator
* @version 1.0
*/
@Service
public class GoodsImgServiceImpl extends BaseServiceImpl<GoodsImg, Long> implements GoodsImgService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private GoodsImgDao goodsImgDao;
    
    private GoodsImgRepository goodsImgRepository;
    /**
    *构造方法
    * @param goodsImgRepository 数据容器
    */
    @Autowired
    public GoodsImgServiceImpl( GoodsImgRepository goodsImgRepository) {
        super(goodsImgRepository);
        this.goodsImgRepository = goodsImgRepository;
    }

    @Override
    public Page<GoodsImg> list(GoodsImgCondition goodsImgCondition, Pageable pageable) {
        log.info("商品图片查询列表");
        return goodsImgDao.list(goodsImgCondition, pageable);
    }
    
    @Override
    public List<GoodsImg> list(GoodsImgCondition goodsImgCondition) {
        log.info("商品图片查询列表无分页");
        return goodsImgDao.list(goodsImgCondition);
    }

    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<GoodsImg>  findAllByGoodsId(Long goodsId){
        return goodsImgRepository.findAllByGoodsId(goodsId);
    }
    
     @Override
    public Page<GoodsImg>  findAllByGoodsId(Long goodsId, Pageable pageable){
        return goodsImgRepository.findAllByGoodsId(goodsId,pageable);
    }
    @Override 
    public GoodsImg findBy(String field,Object value){
        log.info("商品图片根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return goodsImgDao.findBy(field,value);
    }
    
    @Override 
    public List<GoodsImg> findAllBy(String field,Object value){
        log.info("商品图片根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return goodsImgDao.findAllBy(field,value);
    }
}
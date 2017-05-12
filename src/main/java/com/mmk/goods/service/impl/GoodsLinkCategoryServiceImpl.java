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
import com.mmk.goods.dao.GoodsLinkCategoryRepository;
import com.mmk.goods.model.GoodsLinkCategory;
import com.mmk.goods.condition.GoodsLinkCategoryCondition;
import com.mmk.goods.service.GoodsLinkCategoryService;
import com.mmk.goods.dao.GoodsLinkCategoryDao;
/**
* GoodsLinkCategoryServiceImpl: 商品分类关联表 业务服务层实现
* 2017-05-10 11:48:45
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
@Service
public class GoodsLinkCategoryServiceImpl extends BaseServiceImpl<GoodsLinkCategory, Long> implements GoodsLinkCategoryService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private GoodsLinkCategoryDao goodsLinkCategoryDao;
    
    private GoodsLinkCategoryRepository goodsLinkCategoryRepository;
    /**
    *构造方法
    * @param goodsLinkCategoryRepository 数据容器
    */
    @Autowired
    public GoodsLinkCategoryServiceImpl( GoodsLinkCategoryRepository goodsLinkCategoryRepository) {
        super(goodsLinkCategoryRepository);
        this.goodsLinkCategoryRepository = goodsLinkCategoryRepository;
    }

    @Override
    public Page<GoodsLinkCategory> list(GoodsLinkCategoryCondition goodsLinkCategoryCondition, Pageable pageable) {
        log.info("商品分类关联表查询列表");
        return goodsLinkCategoryDao.list(goodsLinkCategoryCondition, pageable);
    }
    
    @Override
    public List<GoodsLinkCategory> list(GoodsLinkCategoryCondition goodsLinkCategoryCondition) {
        log.info("商品分类关联表查询列表无分页");
        return goodsLinkCategoryDao.list(goodsLinkCategoryCondition);
    }

    /**
     * 根据字段获取所有符合的记录
     * @param categoryId 分类主键
     * @return 符合条件的所有对象
     */
    @Override
    public List<GoodsLinkCategory>  findAllByCategoryId(Long categoryId){
        return goodsLinkCategoryRepository.findAllByCategoryId(categoryId);
    }
    
     @Override
    public Page<GoodsLinkCategory>  findAllByCategoryId(Long categoryId, Pageable pageable){
        return goodsLinkCategoryRepository.findAllByCategoryId(categoryId,pageable);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品主键
     * @return 符合条件的所有对象
     */
    @Override
    public List<GoodsLinkCategory>  findAllByGoodsId(Long goodsId){
        return goodsLinkCategoryRepository.findAllByGoodsId(goodsId);
    }
    
     @Override
    public Page<GoodsLinkCategory>  findAllByGoodsId(Long goodsId, Pageable pageable){
        return goodsLinkCategoryRepository.findAllByGoodsId(goodsId,pageable);
    }
    @Override 
    public GoodsLinkCategory findBy(String field,Object value){
        log.info("商品分类关联表根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return goodsLinkCategoryDao.findBy(field,value);
    }
    
    @Override 
    public List<GoodsLinkCategory> findAllBy(String field,Object value){
        log.info("商品分类关联表根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return goodsLinkCategoryDao.findAllBy(field,value);
    }
}
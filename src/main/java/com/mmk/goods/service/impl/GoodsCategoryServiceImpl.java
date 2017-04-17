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
import com.mmk.goods.dao.GoodsCategoryRepository;
import com.mmk.goods.model.GoodsCategory;
import com.mmk.goods.condition.GoodsCategoryCondition;
import com.mmk.goods.service.GoodsCategoryService;
import com.mmk.goods.dao.GoodsCategoryDao;
/**
* GoodsCategoryServiceImpl: 商品分类 业务服务层实现
* 2017-04-17 17:46:40
* @author sunzhongqiang
* @version 1.0
*/
@Service
public class GoodsCategoryServiceImpl extends BaseServiceImpl<GoodsCategory, Long> implements GoodsCategoryService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private GoodsCategoryDao goodsCategoryDao;
    
    private GoodsCategoryRepository goodsCategoryRepository;
    /**
    *构造方法
    * @param goodsCategoryRepository 数据容器
    */
    @Autowired
    public GoodsCategoryServiceImpl( GoodsCategoryRepository goodsCategoryRepository) {
        super(goodsCategoryRepository);
        this.goodsCategoryRepository = goodsCategoryRepository;
    }

    @Override
    public Page<GoodsCategory> list(GoodsCategoryCondition goodsCategoryCondition, Pageable pageable) {
        log.info("商品分类查询列表");
        return goodsCategoryDao.list(goodsCategoryCondition, pageable);
    }
    
    @Override
    public List<GoodsCategory> list(GoodsCategoryCondition goodsCategoryCondition) {
        log.info("商品分类查询列表无分页");
        return goodsCategoryDao.list(goodsCategoryCondition);
    }

    /**
     * 根据字段获取所有符合的记录
     * @param parentId 父分类的id
     * @return 符合条件的所有对象
     */
    @Override
    public List<GoodsCategory>  findAllByParentId(Long parentId){
        return goodsCategoryRepository.findAllByParentId(parentId);
    }
    
     @Override
    public Page<GoodsCategory>  findAllByParentId(Long parentId, Pageable pageable){
        return goodsCategoryRepository.findAllByParentId(parentId,pageable);
    }
    @Override 
    public GoodsCategory findBy(String field,Object value){
        log.info("商品分类根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return goodsCategoryDao.findBy(field,value);
    }
    
    @Override 
    public List<GoodsCategory> findAllBy(String field,Object value){
        log.info("商品分类根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return goodsCategoryDao.findAllBy(field,value);
    }
}
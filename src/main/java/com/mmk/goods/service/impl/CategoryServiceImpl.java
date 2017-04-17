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
import com.mmk.goods.dao.CategoryRepository;
import com.mmk.goods.model.Category;
import com.mmk.goods.condition.CategoryCondition;
import com.mmk.goods.service.CategoryService;
import com.mmk.goods.dao.CategoryDao;
/**
* CategoryServiceImpl: 商品分类 业务服务层实现
* 2017-04-17 18:14:42
* @author codegene
* @version 1.0
*/
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long> implements CategoryService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private CategoryDao categoryDao;
    
    private CategoryRepository categoryRepository;
    /**
    *构造方法
    * @param categoryRepository 数据容器
    */
    @Autowired
    public CategoryServiceImpl( CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> list(CategoryCondition categoryCondition, Pageable pageable) {
        log.info("商品分类查询列表");
        return categoryDao.list(categoryCondition, pageable);
    }
    
    @Override
    public List<Category> list(CategoryCondition categoryCondition) {
        log.info("商品分类查询列表无分页");
        return categoryDao.list(categoryCondition);
    }

    /**
     * 根据字段获取所有符合的记录
     * @param parentId 父分类的id
     * @return 符合条件的所有对象
     */
    @Override
    public List<Category>  findAllByParentId(Long parentId){
        return categoryRepository.findAllByParentId(parentId);
    }
    
     @Override
    public Page<Category>  findAllByParentId(Long parentId, Pageable pageable){
        return categoryRepository.findAllByParentId(parentId,pageable);
    }
    @Override 
    public Category findBy(String field,Object value){
        log.info("商品分类根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return categoryDao.findBy(field,value);
    }
    
    @Override 
    public List<Category> findAllBy(String field,Object value){
        log.info("商品分类根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return categoryDao.findAllBy(field,value);
    }
}
/*
 *  CategoryRepository 创建于 2017-04-17 18:14:42 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.goods.model.Category;

/**
* CategoryRepository: 商品分类 数据资源层
* 2017-04-17 18:14:42
* @author codegene
* @version 1.0
*/
public interface CategoryRepository extends JpaRepository<Category, Long>{

    /**
     *  根据给定的字段：parentId 父分类的id获取所有符合的记录
     * @param parentId 父分类的id
     * @return 符合条件的所有对象
     * @author codegene
     * 
     */
    List<Category> findAllByParentId(Long parentId);
    /**
     *  根据给定的字段：parentId 父分类的id所有符合的记录
     * @param parentId 父分类的id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author codegene
     * 
     */
    Page<Category> findAllByParentId(Long parentId,Pageable pageable);

}
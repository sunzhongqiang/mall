/*
 *  GoodsCategoryRepository 创建于 2017-04-17 17:46:40 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.goods.model.GoodsCategory;

/**
* GoodsCategoryRepository: 商品分类 数据资源层
* 2017-04-17 17:46:40
* @author sunzhongqiang
* @version 1.0
*/
public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory, Long>{

    /**
     *  根据给定的字段：parentId 父分类的id获取所有符合的记录
     * @param parentId 父分类的id
     * @return 符合条件的所有对象
     * @author sunzhongqiang
     * 
     */
    List<GoodsCategory> findAllByParentId(Long parentId);
    /**
     *  根据给定的字段：parentId 父分类的id所有符合的记录
     * @param parentId 父分类的id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author sunzhongqiang
     * 
     */
    Page<GoodsCategory> findAllByParentId(Long parentId,Pageable pageable);

}
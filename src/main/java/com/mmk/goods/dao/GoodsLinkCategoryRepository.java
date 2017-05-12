/*
 *  GoodsLinkCategoryRepository 创建于 2017-05-10 11:48:45 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.goods.model.GoodsLinkCategory;

/**
* GoodsLinkCategoryRepository: 商品分类关联表 数据资源层
* 2017-05-10 11:48:45
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface GoodsLinkCategoryRepository extends JpaRepository<GoodsLinkCategory, Long>{

    /**
     *  根据给定的字段：categoryId 分类主键获取所有符合的记录
     * @param categoryId 分类主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<GoodsLinkCategory> findAllByCategoryId(Long categoryId);
    /**
     *  根据给定的字段：categoryId 分类主键所有符合的记录
     * @param categoryId 分类主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<GoodsLinkCategory> findAllByCategoryId(Long categoryId,Pageable pageable);
    /**
     *  根据给定的字段：goodsId 商品主键获取所有符合的记录
     * @param goodsId 商品主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<GoodsLinkCategory> findAllByGoodsId(Long goodsId);
    /**
     *  根据给定的字段：goodsId 商品主键所有符合的记录
     * @param goodsId 商品主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<GoodsLinkCategory> findAllByGoodsId(Long goodsId,Pageable pageable);

}
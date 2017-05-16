/*
 *  GoodsLinkCategoryRepository 创建于 2017-05-12 09:35:07 版权归作者和作者当前组织所有
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
* 2017-05-12 09:35:07
* @author 孙中强 sunzhognqiang
* @version 1.0
*/
public interface GoodsLinkCategoryRepository extends JpaRepository<GoodsLinkCategory, Long>{

    /**
     *  根据给定的字段：categoryId 分类主键获取所有符合的记录
     * @param categoryId 分类主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhognqiang
     * 
     */
    List<GoodsLinkCategory> findAllByCategoryId(Long categoryId);
    /**
     *  根据给定的字段：categoryId 分类主键所有符合的记录
     * @param categoryId 分类主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhognqiang
     * 
     */
    Page<GoodsLinkCategory> findAllByCategoryId(Long categoryId,Pageable pageable);
    /**
     *  根据给定的字段：goodsId 商品主键获取所有符合的记录
     * @param goodsId 商品主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhognqiang
     * 
     */
    List<GoodsLinkCategory> findAllByGoodsId(Long goodsId);
    /**
     *  根据给定的字段：goodsId 商品主键所有符合的记录
     * @param goodsId 商品主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhognqiang
     * 
     */
    Page<GoodsLinkCategory> findAllByGoodsId(Long goodsId,Pageable pageable);
    /**
     *  根据给定的字段：userId 用户主键获取所有符合的记录
     * @param userId 用户主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhognqiang
     * 
     */
    List<GoodsLinkCategory> findAllByUserId(Long userId);
    /**
     *  根据给定的字段：userId 用户主键所有符合的记录
     * @param userId 用户主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhognqiang
     * 
     */
    Page<GoodsLinkCategory> findAllByUserId(Long userId,Pageable pageable);
    
    /**
     * 根据用户，商品，分类三者获取对应的值
     * @param userId 用户
     * @param goodsId 商品
     * @param categoryId 分类
     * @return 对应的值
     */
	GoodsLinkCategory findAllByUserIdAndGoodsIdAndCategoryId(Long userId, Long goodsId, Long categoryId);

}
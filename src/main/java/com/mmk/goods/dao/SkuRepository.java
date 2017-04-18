/*
 *  SkuRepository 创建于 2017-04-18 11:24:46 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.goods.model.Sku;

/**
* SkuRepository: 商品SKU 数据资源层
* 2017-04-18 11:24:46
* @author codegenerator
* @version 1.0
*/
public interface SkuRepository extends JpaRepository<Sku, Long>{

    /**
     *  根据给定的字段：goodsId 商品id获取所有符合的记录
     * @param goodsId 商品id
     * @return 符合条件的所有对象
     * @author codegenerator
     * 
     */
    List<Sku> findAllByGoodsId(Long goodsId);
    /**
     *  根据给定的字段：goodsId 商品id所有符合的记录
     * @param goodsId 商品id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author codegenerator
     * 
     */
    Page<Sku> findAllByGoodsId(Long goodsId,Pageable pageable);

}
/*
 *  GoodsImgRepository 创建于 2017-04-24 08:56:29 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.goods.model.GoodsImg;

/**
* GoodsImgRepository: 商品图片 数据资源层
* 2017-04-24 08:56:29
* @author codegenerator
* @version 1.0
*/
public interface GoodsImgRepository extends JpaRepository<GoodsImg, Long>{

    /**
     *  根据给定的字段：goodsId 商品ID获取所有符合的记录
     * @param goodsId 商品ID
     * @return 符合条件的所有对象
     * @author codegenerator
     * 
     */
    List<GoodsImg> findAllByGoodsId(Long goodsId);
    /**
     *  根据给定的字段：goodsId 商品ID所有符合的记录
     * @param goodsId 商品ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author codegenerator
     * 
     */
    Page<GoodsImg> findAllByGoodsId(Long goodsId,Pageable pageable);

}
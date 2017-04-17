/*
 *  GoodsRepository 创建于 2017-04-17 17:45:46 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.goods.model.Goods;

/**
* GoodsRepository: 商品 数据资源层
* 2017-04-17 17:45:46
* @author sunzhongqiang
* @version 1.0
*/
public interface GoodsRepository extends JpaRepository<Goods, Long>{

    /**
     *  根据给定的字段：userId 用户获取所有符合的记录
     * @param userId 用户
     * @return 符合条件的所有对象
     * @author sunzhongqiang
     * 
     */
    List<Goods> findAllByUserId(Long userId);
    /**
     *  根据给定的字段：userId 用户所有符合的记录
     * @param userId 用户
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author sunzhongqiang
     * 
     */
    Page<Goods> findAllByUserId(Long userId,Pageable pageable);

}
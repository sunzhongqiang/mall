/*
 *  ShopRepository 创建于 2017-04-08 08:37:20 版权归作者和作者当前组织所有
 */
package com.mmk.user.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.user.model.Shop;

/**
* ShopRepository: 用户店铺 数据资源层
* 2017-04-08 08:37:20
* @author codegenerator
* @version 1.0
*/
public interface ShopRepository extends JpaRepository<Shop, Long>{


}
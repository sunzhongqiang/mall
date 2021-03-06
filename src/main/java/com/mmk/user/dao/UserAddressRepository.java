/*
 *  UserAddressRepository 创建于 2017-04-08 08:36:43 版权归作者和作者当前组织所有
 */
package com.mmk.user.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.user.model.UserAddress;

/**
* UserAddressRepository: 用户地址 数据资源层
* 2017-04-08 08:36:43
* @author codegenerator
* @version 1.0
*/
public interface UserAddressRepository extends JpaRepository<UserAddress, Long>{


}
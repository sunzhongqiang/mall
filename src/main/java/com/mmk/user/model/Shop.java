/*
 * 
 *  Shop 创建于 2017-04-15 12:34:53 版权归作者和作者当前组织所有
 */
package com.mmk.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* Shop: 用户店铺 数据领域模型
* 2017-04-15 12:34:53
*@author codegenerator
*@version 1.0
*/
@Entity
@Table(name="user_shop")
public class Shop {
    /**
     * 主键
     */
    @Id
    @Column(name="id",columnDefinition="COMMENT '主键'")
    private Long id;

    /**
     * 用户主键
     */
    @Column(name="user_id",columnDefinition="COMMENT '用户主键'")
    private Long userId;

    /**
     * 店铺名称
     */
    @Column(name="title",columnDefinition="COMMENT '店铺名称'")
    private String title;

    /**
     * 店铺状态：open:营业中;closed:关闭;
     */
    @Column(name="status",columnDefinition="COMMENT '店铺状态：open:营业中;closed:关闭;'")
    private String status;

    /**
     * 经营范围
     */
    @Column(name="shop_description",columnDefinition="COMMENT '经营范围'")
    private String shopDescription;

    /**
     * 实体店地址
     */
    @Column(name="address",columnDefinition="COMMENT '实体店地址'")
    private String address;


    /** 
	* @return id ：主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return userId ：用户主键
	*/
    public Long getUserId() {
        return userId;
    }
    /** 
    *@param userId 设置用户主键 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
	* @return title ：店铺名称
	*/
    public String getTitle() {
        return title;
    }
    /** 
    *@param title 设置店铺名称 
    */
    public void setTitle(String title) {
        this.title = title;
    }

    /** 
	* @return status ：店铺状态：open:营业中;closed:关闭;
	*/
    public String getStatus() {
        return status;
    }
    /** 
    *@param status 设置店铺状态：open:营业中;closed:关闭; 
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /** 
	* @return shopDescription ：经营范围
	*/
    public String getShopDescription() {
        return shopDescription;
    }
    /** 
    *@param shopDescription 设置经营范围 
    */
    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    /** 
	* @return address ：实体店地址
	*/
    public String getAddress() {
        return address;
    }
    /** 
    *@param address 设置实体店地址 
    */
    public void setAddress(String address) {
        this.address = address;
    }


}
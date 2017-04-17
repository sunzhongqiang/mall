/*
 * 
 *  Goods 创建于 2017-04-17 17:45:46 版权归作者和作者当前组织所有
 */
package com.mmk.goods.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* Goods: 商品 数据领域模型
* 2017-04-17 17:45:46
*@author sunzhongqiang
*@version 1.0
*/
@Entity
@Table(name="goods")
public class Goods {
    /**
     * 商品主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT '商品主键'")
    private Long id;

    /**
     * 用户
     */
    @Column(name="user_id",columnDefinition="COMMENT '用户'")
    private Long userId;

    /**
     * 商品名称
     */
    @Column(name="title",columnDefinition="COMMENT '商品名称'")
    private String title;

    /**
     * 商品价格
     */
    @Column(name="price",columnDefinition="COMMENT '商品价格'")
    private Double price;

    /**
     * 商品数量
     */
    @Column(name="num",columnDefinition="COMMENT '商品数量'")
    private Long num;

    /**
     * 商品编码
     */
    @Column(name="code",columnDefinition="COMMENT '商品编码'")
    private String code;

    /**
     * 条形码
     */
    @Column(name="barcode",columnDefinition="COMMENT '条形码'")
    private String barcode;

    /**
     * 商品详情
     */
    @Column(name="description",columnDefinition="COMMENT '商品详情'")
    private String description;

    /**
     * 商品原价
     */
    @Column(name="original_price",columnDefinition="COMMENT '商品原价'")
    private Double originalPrice;

    /**
     * 促销价
     */
    @Column(name="promote_price",columnDefinition="COMMENT '促销价'")
    private Double promotePrice;

    /**
     * 已售数量
     */
    @Column(name="saled_number",columnDefinition="COMMENT '已售数量'")
    private Long saledNumber;

    /**
     * 商品相册
     */
    @Column(name="thumb",columnDefinition="COMMENT '商品相册'")
    private String thumb;

    /**
     * 商品主图
     */
    @Column(name="main_img",columnDefinition="COMMENT '商品主图'")
    private String mainImg;

    /**
     * 商品原图
     */
    @Column(name="original_img",columnDefinition="COMMENT '商品原图'")
    private String originalImg;

    /**
     * 商品是否下架
     */
    @Column(name="is_onsale",columnDefinition="COMMENT '商品是否下架'")
    private Long isOnsale;

    /**
     * 添加时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="created",columnDefinition="COMMENT '添加时间'")
    private Date created;

    /**
     * 修改时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="modified",columnDefinition="COMMENT '修改时间'")
    private Date modified;


    /** 
	* @return id ：商品主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置商品主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return userId ：用户
	*/
    public Long getUserId() {
        return userId;
    }
    /** 
    *@param userId 设置用户 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
	* @return title ：商品名称
	*/
    public String getTitle() {
        return title;
    }
    /** 
    *@param title 设置商品名称 
    */
    public void setTitle(String title) {
        this.title = title;
    }

    /** 
	* @return price ：商品价格
	*/
    public Double getPrice() {
        return price;
    }
    /** 
    *@param price 设置商品价格 
    */
    public void setPrice(Double price) {
        this.price = price;
    }

    /** 
	* @return num ：商品数量
	*/
    public Long getNum() {
        return num;
    }
    /** 
    *@param num 设置商品数量 
    */
    public void setNum(Long num) {
        this.num = num;
    }

    /** 
	* @return code ：商品编码
	*/
    public String getCode() {
        return code;
    }
    /** 
    *@param code 设置商品编码 
    */
    public void setCode(String code) {
        this.code = code;
    }

    /** 
	* @return barcode ：条形码
	*/
    public String getBarcode() {
        return barcode;
    }
    /** 
    *@param barcode 设置条形码 
    */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /** 
	* @return description ：商品详情
	*/
    public String getDescription() {
        return description;
    }
    /** 
    *@param description 设置商品详情 
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 
	* @return originalPrice ：商品原价
	*/
    public Double getOriginalPrice() {
        return originalPrice;
    }
    /** 
    *@param originalPrice 设置商品原价 
    */
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    /** 
	* @return promotePrice ：促销价
	*/
    public Double getPromotePrice() {
        return promotePrice;
    }
    /** 
    *@param promotePrice 设置促销价 
    */
    public void setPromotePrice(Double promotePrice) {
        this.promotePrice = promotePrice;
    }

    /** 
	* @return saledNumber ：已售数量
	*/
    public Long getSaledNumber() {
        return saledNumber;
    }
    /** 
    *@param saledNumber 设置已售数量 
    */
    public void setSaledNumber(Long saledNumber) {
        this.saledNumber = saledNumber;
    }

    /** 
	* @return thumb ：商品相册
	*/
    public String getThumb() {
        return thumb;
    }
    /** 
    *@param thumb 设置商品相册 
    */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /** 
	* @return mainImg ：商品主图
	*/
    public String getMainImg() {
        return mainImg;
    }
    /** 
    *@param mainImg 设置商品主图 
    */
    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    /** 
	* @return originalImg ：商品原图
	*/
    public String getOriginalImg() {
        return originalImg;
    }
    /** 
    *@param originalImg 设置商品原图 
    */
    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg;
    }

    /** 
	* @return isOnsale ：商品是否下架
	*/
    public Long getIsOnsale() {
        return isOnsale;
    }
    /** 
    *@param isOnsale 设置商品是否下架 
    */
    public void setIsOnsale(Long isOnsale) {
        this.isOnsale = isOnsale;
    }

    /** 
	* @return created ：添加时间
	*/
    public Date getCreated() {
        return created;
    }
    /** 
    *@param created 设置添加时间 
    */
    public void setCreated(Date created) {
        this.created = created;
    }

    /** 
	* @return modified ：修改时间
	*/
    public Date getModified() {
        return modified;
    }
    /** 
    *@param modified 设置修改时间 
    */
    public void setModified(Date modified) {
        this.modified = modified;
    }


}
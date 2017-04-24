/*
 * 
 *  GoodsImg 创建于 2017-04-24 08:56:29 版权归作者和作者当前组织所有
 */
package com.mmk.goods.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* GoodsImg: 商品图片 数据领域模型
* 2017-04-24 08:56:29
*@author codegenerator
*@version 1.0
*/
@Entity
@Table(name="goods_img")
public class GoodsImg {
    /**
     * 商品相册ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT '商品相册ID'")
    private Long id;

    /**
     * 商品ID
     */
    @Column(name="goods_id",columnDefinition="COMMENT '商品ID'")
    private Long goodsId;

    /**
     * 商品原图
     */
    @Column(name="original_img",columnDefinition="COMMENT '商品原图'")
    private String originalImg;

    /**
     * 商品缩略图1
     */
    @Column(name="small_thumb_img",columnDefinition="COMMENT '商品缩略图1'")
    private String smallThumbImg;

    /**
     * 商品缩略图2
     */
    @Column(name="big_thumb_img",columnDefinition="COMMENT '商品缩略图2'")
    private String bigThumbImg;


    /** 
	* @return id ：商品相册ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置商品相册ID 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return goodsId ：商品ID
	*/
    public Long getGoodsId() {
        return goodsId;
    }
    /** 
    *@param goodsId 设置商品ID 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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
	* @return smallThumbImg ：商品缩略图1
	*/
    public String getSmallThumbImg() {
        return smallThumbImg;
    }
    /** 
    *@param smallThumbImg 设置商品缩略图1 
    */
    public void setSmallThumbImg(String smallThumbImg) {
        this.smallThumbImg = smallThumbImg;
    }

    /** 
	* @return bigThumbImg ：商品缩略图2
	*/
    public String getBigThumbImg() {
        return bigThumbImg;
    }
    /** 
    *@param bigThumbImg 设置商品缩略图2 
    */
    public void setBigThumbImg(String bigThumbImg) {
        this.bigThumbImg = bigThumbImg;
    }


}
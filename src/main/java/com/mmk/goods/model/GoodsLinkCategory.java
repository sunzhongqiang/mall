/*
 * 
 *  GoodsLinkCategory 创建于 2017-05-10 11:48:45 版权归作者和作者当前组织所有
 */
package com.mmk.goods.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* GoodsLinkCategory: 商品分类关联表 数据领域模型
* 2017-05-10 11:48:45
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
@Entity
@Table(name="goods_link_category")
public class GoodsLinkCategory {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT '主键'")
    private Long id;

    /**
     * 分类主键
     */
    @Column(name="category_id",columnDefinition="COMMENT '分类主键'")
    private Long categoryId;

    /**
     * 商品主键
     */
    @Column(name="goods_id",columnDefinition="COMMENT '商品主键'")
    private Long goodsId;


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
	* @return categoryId ：分类主键
	*/
    public Long getCategoryId() {
        return categoryId;
    }
    /** 
    *@param categoryId 设置分类主键 
    */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /** 
	* @return goodsId ：商品主键
	*/
    public Long getGoodsId() {
        return goodsId;
    }
    /** 
    *@param goodsId 设置商品主键 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }


}
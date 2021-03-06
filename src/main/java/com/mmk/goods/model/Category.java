/*
 * 
 *  Category 创建于 2017-04-17 18:14:42 版权归作者和作者当前组织所有
 */
package com.mmk.goods.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* Category: 商品分类 数据领域模型
* 2017-04-17 18:14:42
*@author codegene
*@version 1.0
*/
@Entity
@Table(name="goods_category")
public class Category {
    /**
     * 分类id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT '分类id'")
    private Long id;

    /**
     * 父分类的id
     */
    @Column(name="parent_id",columnDefinition="COMMENT '父分类的id'")
    private Long parentId;

    /**
     * 分类名称
     */
    @Column(name="name",columnDefinition="COMMENT '分类名称'")
    private String name;

    /**
     * 分类路径
     */
    @Column(name="path",columnDefinition="COMMENT '分类路径'")
    private String path;

    /**
     * 排序
     */
    @Column(name="sort_order",columnDefinition="COMMENT '排序'")
    private Long sortOrder;

    /**
     * 是否显示
     */
    @Column(name="is_show",columnDefinition="COMMENT '是否显示'")
    private Long isShow;

    /**
     * 分类标志
     */
    @Column(name="cat_ico",columnDefinition="COMMENT '分类标志'")
    private String catIco;

    /**
     * 分类LOGO
     */
    @Column(name="cat_logo",columnDefinition="COMMENT '分类LOGO'")
    private String catLogo;


    /** 
	* @return id ：分类id
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置分类id 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return parentId ：父分类的id
	*/
    public Long getParentId() {
        return parentId;
    }
    /** 
    *@param parentId 设置父分类的id 
    */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /** 
	* @return name ：分类名称
	*/
    public String getName() {
        return name;
    }
    /** 
    *@param name 设置分类名称 
    */
    public void setName(String name) {
        this.name = name;
    }

    /** 
	* @return path ：分类路径
	*/
    public String getPath() {
        return path;
    }
    /** 
    *@param path 设置分类路径 
    */
    public void setPath(String path) {
        this.path = path;
    }

    /** 
	* @return sortOrder ：排序
	*/
    public Long getSortOrder() {
        return sortOrder;
    }
    /** 
    *@param sortOrder 设置排序 
    */
    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    /** 
	* @return isShow ：是否显示
	*/
    public Long getIsShow() {
        return isShow;
    }
    /** 
    *@param isShow 设置是否显示 
    */
    public void setIsShow(Long isShow) {
        this.isShow = isShow;
    }

    /** 
	* @return catIco ：分类标志
	*/
    public String getCatIco() {
        return catIco;
    }
    /** 
    *@param catIco 设置分类标志 
    */
    public void setCatIco(String catIco) {
        this.catIco = catIco;
    }

    /** 
	* @return catLogo ：分类LOGO
	*/
    public String getCatLogo() {
        return catLogo;
    }
    /** 
    *@param catLogo 设置分类LOGO 
    */
    public void setCatLogo(String catLogo) {
        this.catLogo = catLogo;
    }


}
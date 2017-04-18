/*
 * 
 *  Sku 创建于 2017-04-18 11:24:46 版权归作者和作者当前组织所有
 */
package com.mmk.goods.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* Sku: 商品SKU 数据领域模型
* 2017-04-18 11:24:46
*@author codegenerator
*@version 1.0
*/
@Entity
@Table(name="goods_sku")
public class Sku {
    /**
     * 商品属性ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT '商品属性ID'")
    private Long id;

    /**
     * 商品id
     */
    @Column(name="goods_id",columnDefinition="COMMENT '商品id'")
    private Long goodsId;

    /**
     * 属性名称
     */
    @Column(name="name",columnDefinition="COMMENT '属性名称'")
    private String name;

    /**
     * 属性
     */
    @Column(name="properties",columnDefinition="COMMENT '属性'")
    private String properties;

    /**
     * 属性值
     */
    @Column(name="properties_value",columnDefinition="COMMENT '属性值'")
    private String propertiesValue;

    /**
     * 商品价格
     */
    @Column(name="price",columnDefinition="COMMENT '商品价格'")
    private Double price;

    /**
     * 该sku库存
     */
    @Column(name="stock",columnDefinition="COMMENT '该sku库存'")
    private Long stock;

    /**
     * 商品条形码
     */
    @Column(name="code",columnDefinition="COMMENT '商品条形码'")
    private String code;

    /**
     * 商品重量
     */
    @Column(name="weight",columnDefinition="COMMENT '商品重量'")
    private Long weight;


    /** 
	* @return id ：商品属性ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置商品属性ID 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return goodsId ：商品id
	*/
    public Long getGoodsId() {
        return goodsId;
    }
    /** 
    *@param goodsId 设置商品id 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /** 
	* @return name ：属性名称
	*/
    public String getName() {
        return name;
    }
    /** 
    *@param name 设置属性名称 
    */
    public void setName(String name) {
        this.name = name;
    }

    /** 
	* @return properties ：属性
	*/
    public String getProperties() {
        return properties;
    }
    /** 
    *@param properties 设置属性 
    */
    public void setProperties(String properties) {
        this.properties = properties;
    }

    /** 
	* @return propertiesValue ：属性值
	*/
    public String getPropertiesValue() {
        return propertiesValue;
    }
    /** 
    *@param propertiesValue 设置属性值 
    */
    public void setPropertiesValue(String propertiesValue) {
        this.propertiesValue = propertiesValue;
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
	* @return stock ：该sku库存
	*/
    public Long getStock() {
        return stock;
    }
    /** 
    *@param stock 设置该sku库存 
    */
    public void setStock(Long stock) {
        this.stock = stock;
    }

    /** 
	* @return code ：商品条形码
	*/
    public String getCode() {
        return code;
    }
    /** 
    *@param code 设置商品条形码 
    */
    public void setCode(String code) {
        this.code = code;
    }

    /** 
	* @return weight ：商品重量
	*/
    public Long getWeight() {
        return weight;
    }
    /** 
    *@param weight 设置商品重量 
    */
    public void setWeight(Long weight) {
        this.weight = weight;
    }


}
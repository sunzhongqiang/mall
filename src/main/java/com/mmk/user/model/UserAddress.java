/*
 * 
 *  UserAddress 创建于 2017-04-08 08:36:43 版权归作者和作者当前组织所有
 */
package com.mmk.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* UserAddress: 用户地址 数据领域模型
* 2017-04-08 08:36:43
*@author codegenerator
*@version 1.0
*/
@Entity
@Table(name="user_address")
public class UserAddress {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT '主键'")
    private Long id;

    /**
     * 会员id
     */
    @Column(name="user_id",columnDefinition="COMMENT '会员id'")
    private Long userId;

    /**
     * 收货人姓名
     */
    @Column(name="consignee",columnDefinition="COMMENT '收货人姓名'")
    private String consignee;

    /**
     * 国家
     */
    @Column(name="country",columnDefinition="COMMENT '国家'")
    private Long country;

    /**
     * 国家名称
     */
    @Column(name="county_name",columnDefinition="COMMENT '国家名称'")
    private String countyName;

    /**
     * 省
     */
    @Column(name="province",columnDefinition="COMMENT '省'")
    private Long province;

    /**
     * 省名称
     */
    @Column(name="province_name",columnDefinition="COMMENT '省名称'")
    private String provinceName;

    /**
     * 市
     */
    @Column(name="city",columnDefinition="COMMENT '市'")
    private Long city;

    /**
     * 城市名称
     */
    @Column(name="city_name",columnDefinition="COMMENT '城市名称'")
    private String cityName;

    /**
     * 区、县
     */
    @Column(name="district",columnDefinition="COMMENT '区、县'")
    private Long district;

    /**
     * 区县名称
     */
    @Column(name="district_name",columnDefinition="COMMENT '区县名称'")
    private String districtName;

    /**
     * 地址
     */
    @Column(name="address",columnDefinition="COMMENT '地址'")
    private String address;

    /**
     * 邮编
     */
    @Column(name="zipcode",columnDefinition="COMMENT '邮编'")
    private String zipcode;

    /**
     * 电话
     */
    @Column(name="telephone",columnDefinition="COMMENT '电话'")
    private String telephone;

    /**
     * 手机
     */
    @Column(name="mobile",columnDefinition="COMMENT '手机'")
    private String mobile;

    /**
     * 地址类型：收货地址（recieve），退货地址(refund)
     */
    @Column(name="type",columnDefinition="COMMENT '地址类型：收货地址（recieve），退货地址(refund)'")
    private String type;


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
	* @return userId ：会员id
	*/
    public Long getUserId() {
        return userId;
    }
    /** 
    *@param userId 设置会员id 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
	* @return consignee ：收货人姓名
	*/
    public String getConsignee() {
        return consignee;
    }
    /** 
    *@param consignee 设置收货人姓名 
    */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /** 
	* @return country ：国家
	*/
    public Long getCountry() {
        return country;
    }
    /** 
    *@param country 设置国家 
    */
    public void setCountry(Long country) {
        this.country = country;
    }

    /** 
	* @return countyName ：国家名称
	*/
    public String getCountyName() {
        return countyName;
    }
    /** 
    *@param countyName 设置国家名称 
    */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    /** 
	* @return province ：省
	*/
    public Long getProvince() {
        return province;
    }
    /** 
    *@param province 设置省 
    */
    public void setProvince(Long province) {
        this.province = province;
    }

    /** 
	* @return provinceName ：省名称
	*/
    public String getProvinceName() {
        return provinceName;
    }
    /** 
    *@param provinceName 设置省名称 
    */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /** 
	* @return city ：市
	*/
    public Long getCity() {
        return city;
    }
    /** 
    *@param city 设置市 
    */
    public void setCity(Long city) {
        this.city = city;
    }

    /** 
	* @return cityName ：城市名称
	*/
    public String getCityName() {
        return cityName;
    }
    /** 
    *@param cityName 设置城市名称 
    */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /** 
	* @return district ：区、县
	*/
    public Long getDistrict() {
        return district;
    }
    /** 
    *@param district 设置区、县 
    */
    public void setDistrict(Long district) {
        this.district = district;
    }

    /** 
	* @return districtName ：区县名称
	*/
    public String getDistrictName() {
        return districtName;
    }
    /** 
    *@param districtName 设置区县名称 
    */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /** 
	* @return address ：地址
	*/
    public String getAddress() {
        return address;
    }
    /** 
    *@param address 设置地址 
    */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 
	* @return zipcode ：邮编
	*/
    public String getZipcode() {
        return zipcode;
    }
    /** 
    *@param zipcode 设置邮编 
    */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /** 
	* @return telephone ：电话
	*/
    public String getTelephone() {
        return telephone;
    }
    /** 
    *@param telephone 设置电话 
    */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /** 
	* @return mobile ：手机
	*/
    public String getMobile() {
        return mobile;
    }
    /** 
    *@param mobile 设置手机 
    */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /** 
	* @return type ：地址类型：收货地址（recieve），退货地址(refund)
	*/
    public String getType() {
        return type;
    }
    /** 
    *@param type 设置地址类型：收货地址（recieve），退货地址(refund) 
    */
    public void setType(String type) {
        this.type = type;
    }


}
/*
 * 
 *  User 创建于 2017-04-08 08:36:36 版权归作者和作者当前组织所有
 */
package com.mmk.user.model;

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
* User: 用户 数据领域模型
* 2017-04-08 08:36:36
*@author codegenerator
*@version 1.0
*/
@Entity
@Table(name="user")
public class User {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT '主键'")
    private Long id;

    /**
     * 用户名（电话既用户）
     */
    @Column(name="username",columnDefinition="COMMENT '用户名（电话既用户）'")
    private String username;

    /**
     * 真实名称
     */
    @Column(name="realname",columnDefinition="COMMENT '真实名称'")
    private String realname;

    /**
     * 密码
     */
    @Column(name="password",columnDefinition="COMMENT '密码'")
    private String password;

    /**
     * 微信绑定的openid
     */
    @Column(name="openid",columnDefinition="COMMENT '微信绑定的openid'")
    private String openid;

    /**
     * 是否是商户
     */
    @Column(name="is_seller",columnDefinition="COMMENT '是否是商户'")
    private Boolean isSeller;

    /**
     * 用户状态：enable,disable,启用禁用
     */
    @Column(name="status",columnDefinition="COMMENT '用户状态：enable,disable,启用禁用'")
    private String status;

    /**
     * 创建日期
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="created",columnDefinition="COMMENT '创建日期'")
    private Date created;

    /**
     * 变更日期
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="modified",columnDefinition="COMMENT '变更日期'")
    private Date modified;


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
	* @return username ：用户名（电话既用户）
	*/
    public String getUsername() {
        return username;
    }
    /** 
    *@param username 设置用户名（电话既用户） 
    */
    public void setUsername(String username) {
        this.username = username;
    }

    /** 
	* @return realname ：真实名称
	*/
    public String getRealname() {
        return realname;
    }
    /** 
    *@param realname 设置真实名称 
    */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /** 
	* @return password ：密码
	*/
    public String getPassword() {
        return password;
    }
    /** 
    *@param password 设置密码 
    */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
	* @return openid ：微信绑定的openid
	*/
    public String getOpenid() {
        return openid;
    }
    /** 
    *@param openid 设置微信绑定的openid 
    */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /** 
	* @return isSeller ：是否是商户
	*/
    public Boolean getIsSeller() {
        return isSeller;
    }
    /** 
    *@param isSeller 设置是否是商户 
    */
    public void setIsSeller(Boolean isSeller) {
        this.isSeller = isSeller;
    }

    /** 
	* @return status ：用户状态：enable,disable,启用禁用
	*/
    public String getStatus() {
        return status;
    }
    /** 
    *@param status 设置用户状态：enable,disable,启用禁用 
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /** 
	* @return created ：创建日期
	*/
    public Date getCreated() {
        return created;
    }
    /** 
    *@param created 设置创建日期 
    */
    public void setCreated(Date created) {
        this.created = created;
    }

    /** 
	* @return modified ：变更日期
	*/
    public Date getModified() {
        return modified;
    }
    /** 
    *@param modified 设置变更日期 
    */
    public void setModified(Date modified) {
        this.modified = modified;
    }


}
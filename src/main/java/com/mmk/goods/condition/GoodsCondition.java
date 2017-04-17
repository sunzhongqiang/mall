/*
 * 
 *  GoodsCondition 创建于 2017-04-17 17:45:46 版权归作者和作者当前组织所有
 */
package com.mmk.goods.condition;
import java.util.Date;
import com.mmk.goods.model.Goods;

/**
* GoodsCondition ： 商品 扩展查询模型
* 2017-04-17 17:45:46
*@author sunzhongqiang
*@version 1.0
*
*/
public class GoodsCondition extends Goods{

    private Double priceBegin;
    private Double priceEnd;
    private Long numBegin;
    private Long numEnd;
    private Date createdBegin;
    private Date createdEnd;

    /** 
    * @return priceBegin ：商品价格
    */
    public Double getPriceBegin() {
        return priceBegin;
    }
    /** 
    *@param priceBegin 设置商品价格 开始
    */
    public void setPriceBegin(Double priceBegin) {
        this.priceBegin = priceBegin;
    }
    
     /** 
    * @return priceEnd ：商品价格
    */
    public Double getPriceEnd() {
        return priceEnd;
    }
    /** 
    *@param priceEnd 设置商品价格 开始
    */
    public void setPriceEnd(Double priceEnd) {
        this.priceEnd = priceEnd;
    }
    /** 
    * @return numBegin ：商品数量
    */
    public Long getNumBegin() {
        return numBegin;
    }
    /** 
    *@param numBegin 设置商品数量 开始
    */
    public void setNumBegin(Long numBegin) {
        this.numBegin = numBegin;
    }
    
     /** 
    * @return numEnd ：商品数量
    */
    public Long getNumEnd() {
        return numEnd;
    }
    /** 
    *@param numEnd 设置商品数量 开始
    */
    public void setNumEnd(Long numEnd) {
        this.numEnd = numEnd;
    }
    /** 
    * @return createdBegin ：添加时间
    */
    public Date getCreatedBegin() {
        return createdBegin;
    }
    /** 
    *@param createdBegin 设置添加时间 开始
    */
    public void setCreatedBegin(Date createdBegin) {
        this.createdBegin = createdBegin;
    }
    
     /** 
    * @return createdEnd ：添加时间
    */
    public Date getCreatedEnd() {
        return createdEnd;
    }
    /** 
    *@param createdEnd 设置添加时间 开始
    */
    public void setCreatedEnd(Date createdEnd) {
        this.createdEnd = createdEnd;
    }

}
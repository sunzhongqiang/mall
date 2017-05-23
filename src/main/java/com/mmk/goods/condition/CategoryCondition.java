/*
 * 
 *  CategoryCondition 创建于 2017-04-17 18:14:42 版权归作者和作者当前组织所有
 */
package com.mmk.goods.condition;

import com.mmk.goods.model.Category;

import java.util.ArrayList;
import java.util.List;


/**
* CategoryCondition ： 商品分类 扩展查询模型
* 2017-04-17 18:14:42
*@author codegene
*@version 1.0
*
*/
public class CategoryCondition extends Category{


    private List<CategoryCondition> children = new ArrayList<CategoryCondition>();
    
    private Boolean checked = false;

    public List<CategoryCondition> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryCondition> children) {
        this.children = children;
    }

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}
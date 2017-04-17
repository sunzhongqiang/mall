/*
 * 
 *  GoodsCategoryDaoImpl 创建于 2017-04-17 17:46:40 版权归作者和作者当前组织所有
 */
package com.mmk.goods.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mmk.goods.model.GoodsCategory;
import com.mmk.goods.dao.GoodsCategoryDao;

import com.mmk.goods.condition.GoodsCategoryCondition;



/**
* GoodsCategoryDaoImpl: 商品分类 数据持久层接口实现
*@author sunzhongqiang
*@version 1.0
*
*/
@Repository
public class GoodsCategoryDaoImpl extends SpringDataQueryDaoImpl<GoodsCategory> implements GoodsCategoryDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public GoodsCategoryDaoImpl(){
        super(GoodsCategory.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsCategoryCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author sunzhongqiang
     * 
     */
    @Override 
    public Page<GoodsCategory> list(GoodsCategoryCondition goodsCategoryCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from GoodsCategory model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(goodsCategoryCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+goodsCategoryCondition.getName()+"%");
        }
        if(goodsCategoryCondition.getIsShow()!=null){
            sb.append(" and model.isShow = :isShow ");
            params.put("isShow",goodsCategoryCondition.getIsShow());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<GoodsCategory> list(GoodsCategoryCondition goodsCategoryCondition){
        StringBuffer sb=new StringBuffer("select model from GoodsCategory model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(goodsCategoryCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+goodsCategoryCondition.getName()+"%");
        }
        if(goodsCategoryCondition.getIsShow()!=null){
            sb.append(" and model.isShow = :isShow ");
            params.put("isShow",goodsCategoryCondition.getIsShow());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(GoodsCategoryCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,parent_id,name,path,sort_order,is_show,cat_ico,cat_logo from goods_category  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(StringUtils.isNotBlank(condition.getName())){
            sb.append(" and name like ?3 ");
            params.put(3,"%"+condition.getName()+"%");
        }
        if(condition.getIsShow()!=null){
            sb.append(" and is_show = ?6 ");
            params.put(6,condition.getIsShow());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public GoodsCategory findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsCategory model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<GoodsCategory> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<GoodsCategory> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsCategory model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}
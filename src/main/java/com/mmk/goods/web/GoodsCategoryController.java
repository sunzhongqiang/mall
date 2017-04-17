/*
 * 
 *  商品分类Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.goods.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.goods.service.GoodsCategoryService;
import com.mmk.goods.model.GoodsCategory;
import com.mmk.goods.condition.GoodsCategoryCondition;

/**
*@Title: GoodsCategoryController
*@Description: 商品分类 的web控制层
*@author sunzhongqiang
*/
@RestController
public class GoodsCategoryController {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    @Resource 
    private GoodsCategoryService goodsCategoryService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/goods/goodsCategory/list")
    public ModelAndView list(){
        log.info("商品分类列表查询");
        ModelAndView modelAndView = new ModelAndView("goods/goodsCategory/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param goodsCategoryCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/goods/goodsCategory/gridData")
    @ResponseBody
    public GridData<GoodsCategory> loadList(GoodsCategoryCondition goodsCategoryCondition, EasyPageable pageable){
        log.info("获取商品分类列表数据");
        Page<GoodsCategory> goodsCategoryPage = goodsCategoryService.list(goodsCategoryCondition,pageable.pageable());   
        GridData<GoodsCategory> grid = new GridData<GoodsCategory>(goodsCategoryPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到商品分类新增页面
     */
    @RequestMapping("/goods/goodsCategory/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("goods/goodsCategory/form");
        modelAndView.addObject("goodsCategory", new GoodsCategory());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param goodsCategory  跳转到编辑页面
     */ 
    @RequestMapping("/goods/goodsCategory/edit")
    public ModelAndView editPage(GoodsCategory goodsCategory){
        log.info("商品分类编辑页面");
        goodsCategory = goodsCategoryService.find(goodsCategory.getId());
        ModelAndView modelAndView = new ModelAndView("goods/goodsCategory/form");
        modelAndView.addObject("goodsCategory", goodsCategory);
        return modelAndView ;
    }
    
    
    /**
     * 商品分类数据保存方法
     * @param goodsCategory 要保存的数据
     * @return goodsCategory 保存后的数据
     */
    @RequestMapping("/goods/goodsCategory/save")
    @ResponseBody
    public ResultMsg save(GoodsCategory goodsCategory){
        log.info("商品分类保存");
        try {
            goodsCategoryService.save(goodsCategory);
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultMsg(false,"商品分类保存失败");
        }
        return new ResultMsg(true,"商品分类保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param goodsCategory 参数
     * @return 详情数据
     */ 
    @RequestMapping("/goods/goodsCategory/details")
    @ResponseBody
    public GoodsCategory details(GoodsCategory goodsCategory){
        log.info("商品分类详细信息");
        goodsCategory = goodsCategoryService.find(goodsCategory.getId());
        return goodsCategory;
    }
    
    /**
     * 删除数据操作组方法
     * @param goodsCategory
     * @return
     */
    @RequestMapping("/goods/goodsCategory/delete")
    public ResultMsg delete(GoodsCategory goodsCategory){
        log.info("商品分类删除");
        try {
            goodsCategoryService.delete(goodsCategory);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param  goodsCategoryList
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/goods/goodsCategory/deleteAll")
    public boolean delete(List<GoodsCategory> goodsCategoryList){
        log.info("商品分类批量删除");
        try {
            goodsCategoryService.delete(goodsCategoryList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}
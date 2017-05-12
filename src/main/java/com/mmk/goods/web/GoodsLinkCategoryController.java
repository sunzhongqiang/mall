/*
 * 
 *  商品分类关联表Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.goods.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import com.mmk.goods.condition.GoodsLinkCategoryCondition;
import com.mmk.goods.model.GoodsLinkCategory;
import com.mmk.goods.service.GoodsLinkCategoryService;
import com.mmk.goods.service.GoodsService;

/**
*@Title: GoodsLinkCategoryController
*@Description: 商品分类关联表 的web控制层
*@author 孙中强 sunzhongqiang
*/
@RestController
public class GoodsLinkCategoryController {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    @Resource 
    private GoodsLinkCategoryService goodsLinkCategoryService;
    
    @Resource 
    private GoodsService goodsService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/goods/goodsLinkCategory/list")
    public ModelAndView list(){
        log.info("商品分类关联表列表查询");
        ModelAndView modelAndView = new ModelAndView("goods/goodsLinkCategory/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param goodsLinkCategoryCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/goods/goodsLinkCategory/gridData")
    @ResponseBody
    public GridData<GoodsLinkCategory> loadList(GoodsLinkCategoryCondition goodsLinkCategoryCondition, EasyPageable pageable){
        log.info("获取商品分类关联表列表数据");
        Page<GoodsLinkCategory> goodsLinkCategoryPage = goodsLinkCategoryService.list(goodsLinkCategoryCondition,pageable.pageable());   
        GridData<GoodsLinkCategory> grid = new GridData<GoodsLinkCategory>(goodsLinkCategoryPage);
        return grid;
    }
    
    
    /**
     * 新增页面
     * @return 跳转到商品分类关联表新增页面
     */
    @RequestMapping("/goods/goodsLinkCategory/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("goods/goodsLinkCategory/form");
        modelAndView.addObject("goodsLinkCategory", new GoodsLinkCategory());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param goodsLinkCategory  跳转到编辑页面
     */ 
    @RequestMapping("/goods/goodsLinkCategory/edit")
    public ModelAndView editPage(GoodsLinkCategory goodsLinkCategory){
        log.info("商品分类关联表编辑页面");
        goodsLinkCategory = goodsLinkCategoryService.find(goodsLinkCategory.getId());
        ModelAndView modelAndView = new ModelAndView("goods/goodsLinkCategory/form");
        modelAndView.addObject("goodsLinkCategory", goodsLinkCategory);
        return modelAndView ;
    }
    
    
    /**
     * 商品分类关联表数据保存方法
     * @param goodsLinkCategory 要保存的数据
     * @return goodsLinkCategory 保存后的数据
     */
    @RequestMapping("/goods/goodsLinkCategory/save")
    @ResponseBody
    public ResultMsg save(GoodsLinkCategory goodsLinkCategory){
        log.info("商品分类关联表保存");
        try {
            goodsLinkCategoryService.save(goodsLinkCategory);
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultMsg(false,"商品分类关联表保存失败");
        }
        return new ResultMsg(true,"商品分类关联表保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param goodsLinkCategory 参数
     * @return 详情数据
     */ 
    @RequestMapping("/goods/goodsLinkCategory/details")
    @ResponseBody
    public GoodsLinkCategory details(GoodsLinkCategory goodsLinkCategory){
        log.info("商品分类关联表详细信息");
        goodsLinkCategory = goodsLinkCategoryService.find(goodsLinkCategory.getId());
        return goodsLinkCategory;
    }
    
    /**
     * 删除数据操作组方法
     * @param goodsLinkCategory
     * @return
     */
    @RequestMapping("/goods/goodsLinkCategory/delete")
    public ResultMsg delete(GoodsLinkCategory goodsLinkCategory){
        log.info("商品分类关联表删除");
        try {
            goodsLinkCategoryService.delete(goodsLinkCategory);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param  goodsLinkCategoryList
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/goods/goodsLinkCategory/deleteAll")
    public boolean delete(List<GoodsLinkCategory> goodsLinkCategoryList){
        log.info("商品分类关联表批量删除");
        try {
            goodsLinkCategoryService.delete(goodsLinkCategoryList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    
    
}
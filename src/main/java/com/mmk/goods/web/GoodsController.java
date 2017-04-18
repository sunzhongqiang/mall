/*
 * 
 *  商品Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.goods.condition.GoodsCondition;
import com.mmk.goods.model.Goods;
import com.mmk.goods.model.Sku;
import com.mmk.goods.service.GoodsService;

/**
*@Title: GoodsController
*@Description: 商品 的web控制层
*@author sunzhongqiang
*/
@RestController
public class GoodsController {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    @Resource 
    private GoodsService goodsService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/goods/goods/list")
    public ModelAndView list(){
        log.info("商品列表查询");
        ModelAndView modelAndView = new ModelAndView("goods/goods/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param goodsCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/goods/goods/gridData")
    @ResponseBody
    public GridData<Goods> loadList(GoodsCondition goodsCondition, EasyPageable pageable){
        log.info("获取商品列表数据");
        Page<Goods> goodsPage = goodsService.list(goodsCondition,pageable.pageable());   
        GridData<Goods> grid = new GridData<Goods>(goodsPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到商品新增页面
     */
    @RequestMapping("/goods/goods/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("goods/goods/form");
        modelAndView.addObject("goods", new Goods());
        modelAndView.addObject("goodsSku", new Sku());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param goods  跳转到编辑页面
     */ 
    @RequestMapping("/goods/goods/edit")
    public ModelAndView editPage(Goods goods){
        log.info("商品编辑页面");
        goods = goodsService.find(goods.getId());
        ModelAndView modelAndView = new ModelAndView("goods/goods/form");
        modelAndView.addObject("goods", goods);
        return modelAndView ;
    }
    
    
    /**
     * 商品数据保存方法
     * @param goods 要保存的数据
     * @return goods 保存后的数据
     */
    @RequestMapping("/goods/goods/save")
    @ResponseBody
    public ResultMsg save(Goods goods){
        log.info("商品保存");
        try {
            goodsService.save(goods);
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultMsg(false,"商品保存失败");
        }
        return new ResultMsg(true,"商品保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param goods 参数
     * @return 详情数据
     */ 
    @RequestMapping("/goods/goods/details")
    @ResponseBody
    public Goods details(Goods goods){
        log.info("商品详细信息");
        goods = goodsService.find(goods.getId());
        return goods;
    }
    
    /**
     * 删除数据操作组方法
     * @param goods
     * @return
     */
    @RequestMapping("/goods/goods/delete")
    public ResultMsg delete(Goods goods){
        log.info("商品删除");
        try {
            goodsService.delete(goods);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param  goodsList
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/goods/goods/deleteAll")
    public boolean delete(List<Goods> goodsList){
        log.info("商品批量删除");
        try {
            goodsService.delete(goodsList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}
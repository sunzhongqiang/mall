/*
 * 
 *  商品SKUController 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.goods.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import com.mmk.goods.condition.SkuCondition;
import com.mmk.goods.model.Sku;
import com.mmk.goods.service.SkuService;

/**
*@Title: SkuController
*@Description: 商品SKU 的web控制层
*@author codegenerator
*/
@RestController
public class SkuController {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    @Resource 
    private SkuService skuService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/goods/sku/list")
    public ModelAndView list(){
        log.info("商品SKU列表查询");
        ModelAndView modelAndView = new ModelAndView("goods/sku/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param skuCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/goods/sku/gridData")
    @ResponseBody
    public GridData<Sku> loadList(SkuCondition skuCondition, EasyPageable pageable){
        log.info("获取商品SKU列表数据");
        Page<Sku> skuPage = skuService.list(skuCondition,pageable.pageable());   
        GridData<Sku> grid = new GridData<Sku>(skuPage);
        return grid;
    }
    
    /**
     * 商品ID获取商品的所有属性
     * @param goodsId  商品主键
     * @return skuList 查询到的商品属性
     */
    @RequestMapping("/goods/sku/findSku")
    @ResponseBody
    public List<Sku> findSkuByGoodsId(Long goodsId){
        log.info("商品ID获取商品的所有属性");
        return skuService.findAllByGoodsId(goodsId);
    }
    
    /**
     * 新增页面
     * @return 跳转到商品SKU新增页面
     */
    @RequestMapping("/goods/sku/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("goods/sku/form");
        modelAndView.addObject("sku", new Sku());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param sku  跳转到编辑页面
     */ 
    @RequestMapping("/goods/sku/edit")
    public ModelAndView editPage(Sku sku){
        log.info("商品SKU编辑页面");
        sku = skuService.find(sku.getId());
        ModelAndView modelAndView = new ModelAndView("goods/sku/form");
        modelAndView.addObject("sku", sku);
        return modelAndView ;
    }
    
    
    /**
     * 商品SKU数据保存方法
     * @param sku 要保存的数据
     * @return sku 保存后的数据
     */
    @RequestMapping("/goods/sku/save")
    @ResponseBody
    public ResultMsg save(@RequestBody List<Sku> skuList,Long goodsId){
        log.info("商品SKU保存");
        try {
        	 for (Sku goodsSku : skuList){
             	goodsSku.setGoodsId(goodsId);
                skuService.save(goodsSku);
             }
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultMsg(false,"商品SKU保存失败");
        }
        return new ResultMsg(true,"商品SKU保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param sku 参数
     * @return 详情数据
     */ 
    @RequestMapping("/goods/sku/details")
    @ResponseBody
    public Sku details(Sku sku){
        log.info("商品SKU详细信息");
        sku = skuService.find(sku.getId());
        return sku;
    }
    
    /**
     * 删除数据操作组方法
     * @param sku
     * @return
     */
    @RequestMapping("/goods/sku/delete")
    public ResultMsg delete(Sku sku){
        log.info("商品SKU删除");
        try {
            skuService.delete(sku);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param  skuList
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/goods/sku/deleteAll")
    public boolean delete(List<Sku> skuList){
        log.info("商品SKU批量删除");
        try {
            skuService.delete(skuList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}
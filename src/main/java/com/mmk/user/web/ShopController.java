/*
 * 
 *  用户店铺Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.user.web;

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
import com.mmk.user.service.ShopService;
import com.mmk.user.model.Shop;
import com.mmk.user.condition.ShopCondition;

/**
*@Title: ShopController
*@Description: 用户店铺 的web控制层
*@author codegenerator
*/
@RestController
public class ShopController {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    @Resource 
    private ShopService shopService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/user/shop/list")
    public ModelAndView list(){
        log.info("用户店铺列表查询");
        ModelAndView modelAndView = new ModelAndView("user/shop/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param shopCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/user/shop/gridData")
    @ResponseBody
    public GridData<Shop> loadList(ShopCondition shopCondition, EasyPageable pageable){
        log.info("获取用户店铺列表数据");
        Page<Shop> shopPage = shopService.list(shopCondition,pageable.pageable());   
        GridData<Shop> grid = new GridData<Shop>(shopPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到用户店铺新增页面
     */
    @RequestMapping("/user/shop/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("user/shop/form");
        modelAndView.addObject("shop", new Shop());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param shop  跳转到编辑页面
     */ 
    @RequestMapping("/user/shop/edit")
    public ModelAndView editPage(Shop shop){
        log.info("用户店铺编辑页面");
        shop = shopService.find(shop.getId());
        ModelAndView modelAndView = new ModelAndView("user/shop/form");
        modelAndView.addObject("shop", shop);
        return modelAndView ;
    }
    
    
    /**
     * 用户店铺数据保存方法
     * @param shop 要保存的数据
     * @return shop 保存后的数据
     */
    @RequestMapping("/user/shop/save")
    @ResponseBody
    public ResultMsg save(Shop shop){
        log.info("用户店铺保存");
        try {
            shopService.save(shop);
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultMsg(false,"用户店铺保存失败");
        }
        return new ResultMsg(true,"用户店铺保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param shop 参数
     * @return 详情数据
     */ 
    @RequestMapping("/user/shop/details")
    @ResponseBody
    public Shop details(Shop shop){
        log.info("用户店铺详细信息");
        shop = shopService.find(shop.getId());
        return shop;
    }
    
    /**
     * 删除数据操作组方法
     * @param page shop
     * @return
     */
    @RequestMapping("/user/shop/delete")
    public ResultMsg delete(Shop shop){
        log.info("用户店铺删除");
        try {
            shopService.delete(shop);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page shop
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/user/shop/deleteAll")
    public boolean delete(List<Shop> shopList){
        log.info("用户店铺批量删除");
        try {
            shopService.delete(shopList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}
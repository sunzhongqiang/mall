/*
 * 
 *  商品图片Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.goods.service.GoodsImgService;
import com.mmk.goods.model.GoodsImg;
import com.mmk.goods.condition.GoodsImgCondition;

/**
*@Title: GoodsImgController
*@Description: 商品图片 的web控制层
*@author codegenerator
*/
@RestController
public class GoodsImgController {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    @Resource 
    private GoodsImgService goodsImgService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/goods/goodsImg/list")
    public ModelAndView list(){
        log.info("商品图片列表查询");
        ModelAndView modelAndView = new ModelAndView("goods/goodsImg/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param goodsImgCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/goods/goodsImg/gridData")
    @ResponseBody
    public GridData<GoodsImg> loadList(GoodsImgCondition goodsImgCondition, EasyPageable pageable){
        log.info("获取商品图片列表数据");
        Page<GoodsImg> goodsImgPage = goodsImgService.list(goodsImgCondition,pageable.pageable());   
        GridData<GoodsImg> grid = new GridData<GoodsImg>(goodsImgPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到商品图片新增页面
     */
    @RequestMapping("/goods/goodsImg/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("goods/goodsImg/form");
        modelAndView.addObject("goodsImg", new GoodsImg());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param goodsImg  跳转到编辑页面
     */ 
    @RequestMapping("/goods/goodsImg/edit")
    public ModelAndView editPage(GoodsImg goodsImg){
        log.info("商品图片编辑页面");
        goodsImg = goodsImgService.find(goodsImg.getId());
        ModelAndView modelAndView = new ModelAndView("goods/goodsImg/form");
        modelAndView.addObject("goodsImg", goodsImg);
        return modelAndView ;
    }
    
    
    /**
     * 商品图片数据保存方法
     * @param goodsImg 要保存的数据
     * @return goodsImg 保存后的数据
     */
    @RequestMapping("/goods/goodsImg/save")
    @ResponseBody
    public ResultMsg save(GoodsImg goodsImg){
        log.info("商品图片保存");
        try {
            goodsImgService.save(goodsImg);
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultMsg(false,"商品图片保存失败");
        }
        return new ResultMsg(true,"商品图片保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param goodsImg 参数
     * @return 详情数据
     */ 
    @RequestMapping("/goods/goodsImg/details")
    @ResponseBody
    public GoodsImg details(GoodsImg goodsImg){
        log.info("商品图片详细信息");
        goodsImg = goodsImgService.find(goodsImg.getId());
        return goodsImg;
    }
    
    /**
     * 删除数据操作组方法
     * @param goodsImg
     * @return
     */
    @RequestMapping("/goods/goodsImg/delete")
    public ResultMsg delete(GoodsImg goodsImg){
        log.info("商品图片删除");
        try {
            goodsImgService.delete(goodsImg);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param  goodsImgList
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/goods/goodsImg/deleteAll")
    public boolean delete(List<GoodsImg> goodsImgList){
        log.info("商品图片批量删除");
        try {
            goodsImgService.delete(goodsImgList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}
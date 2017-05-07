/*
 * 
 *  商品Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.goods.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.CurrentUser;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import com.mmk.common.tool.FileClient;
import com.mmk.common.tool.ThumbTool;
import com.mmk.goods.condition.GoodsCondition;
import com.mmk.goods.model.Goods;
import com.mmk.goods.model.GoodsImg;
import com.mmk.goods.model.Sku;
import com.mmk.goods.service.GoodsImgService;
import com.mmk.goods.service.GoodsService;
import com.mmk.goods.service.SkuService;

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
    @Resource 
    private GoodsImgService goodsImgService;
    @Resource 
    private SkuService skuService;

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
    	
    	ModelAndView modelAndView = new ModelAndView("goods/goods/form");
    	
        goods = goodsService.find(goods.getId());
        modelAndView.addObject("goods", goods);
        
        List<Sku> goodsSku = skuService.findAllByGoodsId(goods.getId());
        modelAndView.addObject("skuList", goodsSku);
        List<GoodsImg> goodsImgList = goodsImgService.findByGoodsId(goods.getId());
        modelAndView.addObject("imgList", goodsImgList);
        
        return modelAndView ;
    }
    
    
    /**
     * 商品数据保存方法
     * @param goods 要保存的数据
     * @return goods 保存后的数据
     */
    @RequestMapping("/goods/goods/save")
    @ResponseBody
    public ResultMsg save(@Valid Goods goods , BindingResult result ,String mainImg,
    		String[] originalImg,String[] smallThumbImg,String[] bigThumbImg){
        log.info("商品保存");
        try {
        	goods.setUserId(CurrentUser.getUser().getId());
    	    goodsService.save(goods); 
    	    //商品图片保存
    		List<GoodsImg>  goodImgList = goodsImgService.findByGoodsId(goods.getId());
    	    
        	int imgLength = 0;
    	    if(originalImg != null){
    	    	imgLength = originalImg.length;
    	        // 商品相册的保存
    		    for(int i=0; i<originalImg.length; i++){
    		    	GoodsImg goodImg = new GoodsImg();
    			    if(goodImgList.size() != 0 && goodImgList.size() >= i+1){	
    		    		goodImg = goodImgList.get(i);	    	
    			    }
    		    	goodImg.setGoodsId(goods.getId());
    			    goodImg.setOriginalImg(originalImg[i]);
    			    goodImg.setBigThumbImg(bigThumbImg[i]);
    			    goodImg.setSmallThumbImg(smallThumbImg[i]);
    			    goodsImgService.save(goodImg);
    		    }
    	    }
    	    
    	    if(goodImgList.size() > imgLength){
    	    	for(int j =imgLength; j< goodImgList.size(); j++){
    	    		goodsImgService.delete(goodImgList.get(j));
    	    	}
    	    }
              
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultMsg(false,"商品保存失败");
        }
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("goods", goods);
        return new ResultMsg(true,"商品保存成功",data);
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
    
    /**
     * 商品图片上传
     * @param file 文件
     * @param callback 返回地址
     * @return 上传结果
     */
    @RequestMapping(value = "/goods/goods/upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile file,String callback){
        Map<String, Object> result = new HashMap<String,Object>();
        File dest;
        File size60;
        File size440;
        if(file.getSize()>0){
            try {
               dest = Files.write(Files.createTempFile("copy", "temp"), file.getBytes()).toFile();
               size60 = ThumbTool.size(dest, 350, 350);
               size440 = ThumbTool.size(dest, 600, 600);
               result = FileClient.getDefault().uploadGoods("originalimg", file.getOriginalFilename(), dest,"goodsimg", size440, "thumbimg", size60);
               result.put("success", true);
           } catch (IOException e) {
               result.put("success", false);
               result.put("message", e.getMessage());
               e.printStackTrace();
           }
           dest = null;
           size60 = null;
           size440 = null;
       }
       return result ;
    }
    
}
/*
 * 
 *  用户Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.user.service.UserService;
import com.mmk.user.model.User;
import com.mmk.user.condition.UserCondition;

/**
*@Title: UserController
*@Description: 用户 的web控制层
*@author codegenerator
*/
@RestController
public class UserController {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    @Resource 
    private UserService userService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/user/user/list")
    public ModelAndView list(){
        log.info("用户列表查询");
        ModelAndView modelAndView = new ModelAndView("user/user/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param userCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/user/user/gridData")
    @ResponseBody
    public GridData<User> loadList(UserCondition userCondition, EasyPageable pageable){
        log.info("获取用户列表数据");
        Page<User> userPage = userService.list(userCondition,pageable.pageable());   
        GridData<User> grid = new GridData<User>(userPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到用户新增页面
     */
    @RequestMapping("/user/user/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("user/user/form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param user  跳转到编辑页面
     */ 
    @RequestMapping("/user/user/edit")
    public ModelAndView editPage(User user){
        log.info("用户编辑页面");
        user = userService.find(user.getId());
        ModelAndView modelAndView = new ModelAndView("user/user/form");
        modelAndView.addObject("user", user);
        return modelAndView ;
    }
    
    
    /**
     * 用户数据保存方法
     * @param user 要保存的数据
     * @return user 保存后的数据
     */
    @RequestMapping("/user/user/save")
    @ResponseBody
    public ResultMsg save(User user){
        log.info("用户保存");
        try {
            userService.save(user);
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultMsg(false,"用户保存失败");
        }
        return new ResultMsg(true,"用户保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param user 参数
     * @return 详情数据
     */ 
    @RequestMapping("/user/user/details")
    @ResponseBody
    public User details(User user){
        log.info("用户详细信息");
        user = userService.find(user.getId());
        return user;
    }
    
    /**
     * 删除数据操作组方法
     * @param page user
     * @return
     */
    @RequestMapping("/user/user/delete")
    public ResultMsg delete(User user){
        log.info("用户删除");
        try {
            userService.delete(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page user
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/user/user/deleteAll")
    public boolean delete(List<User> userList){
        log.info("用户批量删除");
        try {
            userService.delete(userList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}
package com.lanou.controller;

import com.lanou.bean.SysMenu;
import com.lanou.service.SysMenuService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by yugege on 17/11/11.
 */
@Controller
public class SysMenuController {

    @Resource
    private SysMenuService service;

    @ResponseBody
    @RequestMapping(value = "/findAllMenu",method = RequestMethod.POST)
    public AjaxResult findAllMenu(){

        List<SysMenu> allMenu = service.findAllMenu();

//        System.out.println("allMenu:---"+allMenu);
        return new AjaxResult(allMenu);
    }

    //添加菜单
    @ResponseBody
    @RequestMapping(value = "/addNewMenu",method = RequestMethod.POST)
    public AjaxResult addNewMenu(@RequestParam("parentName")String ParentName,
                                 @RequestParam("urlkey")String urlKey,
                                 @RequestParam("name")String name,
                                 @RequestParam("type")Integer type,
                                 @RequestParam("url")String url,
                                 @RequestParam("sort")Integer sort,
                                 @RequestParam("status")Integer status){

        System.out.println("ParentName:---"+ParentName);
        SysMenu menuByParentName = service.findMenuByParentName(ParentName);
        System.out.println("menuByParentName:---"+menuByParentName);

        SysMenu sysMenu = new SysMenu();
        sysMenu.setParentId(menuByParentName.getId());
        sysMenu.setUrlkey(urlKey);
        sysMenu.setName(name);
        sysMenu.setUrl(url);
        sysMenu.setSort(sort);
        sysMenu.setStatus(status);
        sysMenu.setType(type);
        sysMenu.setCreateId(1);
        sysMenu.setCreateTime(new Date());

        System.out.println("sysMenu:---"+sysMenu);
        int i = service.addNewMenu(sysMenu);
        if (i > 0){
            System.out.println("增加成功");
        }
        return new AjaxResult(6);
    }

    //更新菜单
    @ResponseBody
    @RequestMapping(value = "/updateMenu",method = RequestMethod.POST)
    public AjaxResult updateMenu(@RequestParam("parentName")String ParentName,
                                 @RequestParam("urlkey")String urlKey,
                                 @RequestParam("name")String name,
                                 @RequestParam("type")Integer type,
                                 @RequestParam("url")String url,
                                 @RequestParam("sort")Integer sort,
                                 @RequestParam("status")Integer status,
                                 HttpServletRequest request){

        System.out.println("ParentName:---"+ParentName);
        SysMenu menuByParentName = service.findMenuByParentName(ParentName);
        System.out.println("menuByParentName:---"+menuByParentName);

        SysMenu sysMenu = (SysMenu) request.getSession().getAttribute("Menu");

        sysMenu.setParentId(menuByParentName.getId());
        sysMenu.setUrlkey(urlKey);
        sysMenu.setName(name);
        sysMenu.setUrl(url);
        sysMenu.setSort(sort);
        sysMenu.setStatus(status);
        sysMenu.setType(type);
        sysMenu.setUpdateId(2);
        sysMenu.setUpdateTime(new Date());

        System.out.println("sysMenu:---"+sysMenu);

        int i = service.updateMenu(sysMenu);
        if (i > 0){
            System.out.println("更新成功");
        }
        return new AjaxResult(6);
    }

    //删除菜单
    @ResponseBody
    @RequestMapping(value = "/deleteMenu",method = RequestMethod.POST)
    public AjaxResult deleteMenu(@RequestParam("MenuId")Integer id){
        System.out.println("id:---"+id);
        int i = service.deleteMenu(id);
        if (i > 0){
            System.out.println("删除成功");
        }
        return new AjaxResult(i);
    }

    //根据id查询菜单
    @ResponseBody
    @RequestMapping(value = "/findMenuById")
    public AjaxResult findMenuById(@RequestParam("MenuId")Integer id,
                                   HttpServletRequest request){

        HttpSession session = request.getSession();

        SysMenu menuById = service.findMenuById(id);

        session.setAttribute("Menu",menuById);

        return new AjaxResult(menuById);
    }

    @ResponseBody
    @RequestMapping(value = "/returnMenu")
    public AjaxResult returnMenu(HttpServletRequest request){

        SysMenu sysMenu = (SysMenu) request.getSession().getAttribute("Menu");


        return new AjaxResult(sysMenu);
    }

    //用于显示父模块
    @ResponseBody
    @RequestMapping(value = "/ParentName")
    public AjaxResult returenParentMenu(HttpServletRequest request){

        SysMenu sysMenu = (SysMenu) request.getSession().getAttribute("Menu");

        return new AjaxResult(sysMenu);
    }

}

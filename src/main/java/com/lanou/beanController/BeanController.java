package com.lanou.beanController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yugege on 17/11/9.
 */
@Controller
public class  BeanController {

    @RequestMapping(value = "/")
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "/welcome";
    }

    /**
     * 权限管理跳转
     */
    //菜单管理
    @RequestMapping(value = "/_menu")
    public String produceB(){
        return "/_menu";
    }


    //角色管理(管理员)
    @RequestMapping(value = "/admin-list")
    public String produceC(){
        return "/admin-list";
    }

    //角色管理-add
    @RequestMapping(value = "/addRole")
    public String produceCA(){
        return "/admin-add";
    }

    //用户管理
    @RequestMapping(value = "/user-list")
    public String produceL(){
        return "/user-list";
    }
    //用户管理-add
    @RequestMapping(value = "/user-add")
    public String UserAdd(){
        return "/user-add";
    }
    @RequestMapping(value = "/user-show")
    public String UserShow(){
        return "/user-show2";
    }




}

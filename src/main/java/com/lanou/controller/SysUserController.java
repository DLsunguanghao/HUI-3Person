package com.lanou.controller;

import com.lanou.bean.SysUser;
import com.lanou.service.SysUserService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by yugege on 17/11/9.
 */
@Controller
public class SysUserController {
    private int b = 0;
    @Resource
    private SysUserService sysUserService;

    @ResponseBody
    @RequestMapping(value = "/findAllUser", method = RequestMethod.POST)
    public AjaxResult findAllUser() {

//        System.out.println("sysUserService.findAllUser():---"+sysUserService.findAllUser());

        return new AjaxResult(sysUserService.findAllUser());
    }

    //添加角色
    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public AjaxResult addUser(@RequestParam("RName") String Adname,
                              @RequestParam("adminName") String name,
                              @RequestParam("password") String pwd,
                              @RequestParam("gender") String gender,
                              @RequestParam("phone") String phone,
                              @RequestParam("email") String email,
                              @RequestParam("input") String remark) {
        SysUser sysUser = new SysUser();
        sysUser.setRealname(Adname);
        sysUser.setUsername(name);
        sysUser.setPassword(pwd);
        sysUser.setTel(phone);
        sysUser.setEmail(email);
        sysUser.setRemark(remark);
        sysUser.setCreateTime(new Date());

        int i = sysUserService.addSysUser(sysUser);
        if (i > 0) {
            System.out.println("添加成功");
        }
        return new AjaxResult();
    }

    //回显
    @ResponseBody
    @RequestMapping(value = "/echoUserById", method = RequestMethod.POST)
    public AjaxResult findUserById(@RequestParam("UserId") Integer id, HttpServletRequest request) {

        HttpSession session = request.getSession();

        SysUser userById = sysUserService.findUserById(id);

        session.setAttribute("User", userById);

        return new AjaxResult(6);
    }

    @ResponseBody
    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public AjaxResult returnUser(HttpServletRequest request) {
        SysUser user = (SysUser) request.getSession().getAttribute("User");

//        System.out.println("user:---"+user);
        return new AjaxResult(user);
    }


    //修改角色
    @ResponseBody
    @RequestMapping(value = "/editor", method = RequestMethod.POST)
    public AjaxResult editerUser(@RequestParam("RName") String Adname,
                                 @RequestParam("adminName") String name,
                                 @RequestParam("password") String pwd,
                                 @RequestParam("gender") String gender,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("email") String email,
                                 @RequestParam("input") String remark,
                                 HttpServletRequest request) {
        SysUser user = (SysUser) request.getSession().getAttribute("User");

        SysUser sysUser = new SysUser();
        sysUser.setId(user.getId());
        sysUser.setRealname(Adname);
        sysUser.setUsername(name);
        sysUser.setPassword(pwd);
        sysUser.setTel(phone);
        sysUser.setEmail(email);
        sysUser.setRemark(remark);
        sysUser.setUpdateTime(new Date());

        int i = sysUserService.editerUser(sysUser);

        if (i > 0) {
            System.out.println("修改成功");
        }

        return new AjaxResult(6);
    }

    //删除角色
    @ResponseBody
    @RequestMapping(value = "/deleteUser")
    public AjaxResult deleteUser(@RequestParam("UserId") Integer id) {
        int i = sysUserService.deleteUser(id);
        if (i > 0) {
            System.out.println("删除成功");
        }
        return new AjaxResult(6);
    }

    //查询
    @ResponseBody
    @RequestMapping(value = "/findUserByCondition", method = RequestMethod.POST)
    public AjaxResult findUserByCondition(@RequestParam("string") String string) {
//        System.out.println("string:---" + string);

        //将字符串按照","分割;
        String[] sourceStr = string.split(",");

//        StringTokenizer tokenizer = new StringTokenizer(string, ",");
//        System.out.println("sourceStr:---" + sourceStr[i]);
//        while (tokenizer.hasMoreElements()) {
//        }
        Map map = new HashMap();

        for (int i = 0; i < sourceStr.length; i++) {
            map.put(i, sourceStr[i]);
            b = i;
        }
        System.out.println("b:---" + b);

        if (b == 0) {
            String name = (String) map.get(b);
            String tel = null;
            String email = null;
            System.out.println("name:---" + name);

            List<SysUser> userByCondition = sysUserService.findUserByCondition(name, email, tel);
            return new AjaxResult(userByCondition);
        } else if (b == 1) {
            String name = (String) map.get(0);
            String tel = (String) map.get(1);
            String email = null;

            System.out.println("name:---" + name);
            System.out.println("tel:---" + tel);

            List<SysUser> userByCondition = sysUserService.findUserByCondition(name, email, tel);

            return new AjaxResult(userByCondition);

        } else if (b == 2) {
            String name = (String) map.get(0);
            String tel = (String) map.get(1);
            String email = (String) map.get(2);

            System.out.println("name:---" + name);
            System.out.println("tel:---" + tel);
            System.out.println("email:---" + email);

            List<SysUser> userByCondition = sysUserService.findUserByCondition(name, email, tel);
            return new AjaxResult(userByCondition);

        } else {
            return new AjaxResult(null);
        }
    }


}

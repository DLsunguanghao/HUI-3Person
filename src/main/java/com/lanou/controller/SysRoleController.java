package com.lanou.controller;

import com.lanou.bean.SysRole;
import com.lanou.bean.SysUser;
import com.lanou.service.SysRoleService;
import com.lanou.service.SysUserService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by yugege on 17/11/9.
 */
@Controller
public class SysRoleController {

    @Resource
    private SysRoleService service;
    @Resource
    private SysUserService sysUserService;

    @ResponseBody
    @RequestMapping(value = "/findAllSyeRole")
    public AjaxResult findAllSysRole(){

        List<SysRole> allSyeRole = service.findAllSyeRole();

//        System.out.println("allSyeRole:---"+allSyeRole);

        return new AjaxResult(allSyeRole);
    }

    @ResponseBody
    @RequestMapping(value = "/addAR",method = RequestMethod.POST)
    public AjaxResult addSysRole(@RequestParam("RName")String Adname,
                                 @RequestParam("adminName")String name,
                                 @RequestParam("password")String pwd,
                                 @RequestParam("gender")String gender,
                                 @RequestParam("phone")String phone,
                                 @RequestParam("email")String email,
                                 @RequestParam("input")String remark){

        System.out.println(Adname+name+pwd+gender+phone+email+remark);

        SysRole role = new SysRole();
        role.setName(Adname);
        role.setCreateId(1);
        role.setCreateTime(new Date());
        role.setStatus(1);

        SysUser user = new SysUser();
        user.setUsername(name);
        user.setPassword(pwd);
        user.setEmail(email);
        user.setCreateTime(new Date());
        user.setRemark(remark);
        user.setTel(phone);

        int i = service.addSysRole(role);
        if (i > 0){
            System.out.println("插入SysRole表成功");
        }

        int i1 = sysUserService.addSysUser(user);
        if (i1 >0){
            System.out.println("插入SysUser表成功");
        }

        return new AjaxResult(6);
    }



}

package com.lanou.controller;

import com.lanou.bean.SysRole;
import com.lanou.bean.SysUser;
import com.lanou.service.SysRoleService;
import com.lanou.service.SysUserService;
import com.lanou.utils.AjaxResult;
import com.sun.org.apache.regexp.internal.RE;
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
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public AjaxResult addSysRole(@RequestParam("RName")String Adname,
                                 @RequestParam("adminName")String name,
                                 @RequestParam("password")String pwd,
                                 @RequestParam("gender")String gender,
                                 @RequestParam("phone")String phone,
                                 @RequestParam("email")String email,
                                 @RequestParam("input")String remark){

//        System.out.println(Adname+name+pwd+gender+phone+email+remark);

        SysRole role = new SysRole();
        role.setName(Adname);
        role.setCreateId(1);
        role.setCreateTime(new Date());
        role.setStatus(1);
        role.setRemark(remark);

        SysUser user = new SysUser();
        user.setUsername(name);
        user.setPassword(pwd);
        user.setEmail(email);
        user.setCreateTime(new Date());
        user.setRemark(remark);
        user.setTel(phone);
        user.setRealname(Adname);

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

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public AjaxResult deleteSysRole(@RequestParam("SysRoleId")Integer id){

        int i = service.deleteSysRole(id);

        if (i > 0){
            System.out.println("删除成功");
        }

        return new AjaxResult(6);
    }


    //模糊查询
    @ResponseBody
    @RequestMapping(value = "/findByAdminName",method = RequestMethod.POST)
    public AjaxResult findByAdminName(@RequestParam("adminName")String name){

        List<SysRole> sysRole = service.findSysRole(name);

//        System.out.println("sysRole:---"+sysRole);
        return new AjaxResult(sysRole);
    }

    //编辑(显示/隐藏)
    @ResponseBody
    @RequestMapping(value = "/updataSysRole",method = RequestMethod.POST)
    public AjaxResult updataSysRole(@RequestParam("id")Integer id){

        SysRole byId = service.findById(id);

//        System.out.println("byI:---"+byId.getStatus());

        if (byId.getStatus() == 1) {
            byId.setStatus(2);
            int i = service.updataSysRole(byId);
            if (i >0){
                System.out.println("更新成功");
            }
        }else if (byId.getStatus() ==2){

            byId.setStatus(1);
            int i = service.updataSysRole(byId);
            if (i >0){
                System.out.println("更新成功");
            }
        }
        return new AjaxResult(6);
    }


}

package com.lanou.service;

import com.lanou.bean.SysUser;

import java.util.List;

/**
 * Created by yugege on 17/11/9.
 */
public interface SysUserService {

    int addSysUser(SysUser user);

    List<SysUser> findAllUser();

    int editerUser(SysUser user);

    int deleteUser(Integer id);

    SysUser findUserById(Integer id);

    List<SysUser> findUserByCondition(String name,String email,String tel);
}

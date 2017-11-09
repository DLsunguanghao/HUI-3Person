package com.lanou.service;

import com.lanou.bean.SysRole;
import com.lanou.bean.SysUser;

import java.util.List;

/**
 * Created by yugege on 17/11/9.
 */
public interface SysRoleService {
    List<SysRole> findAllSyeRole();

    int  addSysRole(SysRole sysRole);

    SysRole findById(Integer id);

    int deleteSysRole(Integer id);

    //模糊查询
    List<SysRole> findSysRole(String name);

    int updataSysRole(SysRole sysRole);
}

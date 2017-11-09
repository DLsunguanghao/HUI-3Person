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
}

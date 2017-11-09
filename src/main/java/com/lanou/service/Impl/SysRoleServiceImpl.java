package com.lanou.service.Impl;

import com.lanou.bean.SysRole;
import com.lanou.bean.SysUser;
import com.lanou.mapper.SysRoleMapper;
import com.lanou.mapper.SysUserMapper;
import com.lanou.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yugege on 17/11/9.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper mapper;

    @Override
    public List<SysRole> findAllSyeRole() {
        return mapper.findAllSysRole();
    }

    @Override
    public int addSysRole(SysRole sysRole) {
        return mapper.insertSelective(sysRole);
    }

    @Override
    public SysRole findById(Integer id) {
        return mapper.findById(id);
    }

    @Override
    public int deleteSysRole(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }
}

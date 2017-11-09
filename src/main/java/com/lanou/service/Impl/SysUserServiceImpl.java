package com.lanou.service.Impl;

import com.lanou.bean.SysUser;
import com.lanou.mapper.SysUserMapper;
import com.lanou.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yugege on 17/11/9.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper mapper;

    @Override
    public int addSysUser(SysUser user) {
        return mapper.insertSelective(user);
    }
}

package com.lanou.service.Impl;

import com.lanou.bean.SysUser;
import com.lanou.mapper.SysUserMapper;
import com.lanou.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<SysUser> findAllUser() {
        return mapper.findAllSyeuser();
    }

    @Override
    public int editerUser(SysUser user) {

        System.out.println("user:---"+user);
        System.out.println(mapper.updateByPrimaryKeySelective(user));
        return mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysUser findUserById(Integer id) {
        return mapper.findUserById(id);
    }

    @Override
    public List<SysUser> findUserByCondition(String name, String email, String tel) {
//        System.out.println("mapper.findSysUserByNameAndEmailAndTel(name,email,tel):---"+mapper.findSysUserByNameAndEmailAndTel(name,email,tel));
        return mapper.findSysUserByNameAndEmailAndTel(name,email,tel);
    }
}

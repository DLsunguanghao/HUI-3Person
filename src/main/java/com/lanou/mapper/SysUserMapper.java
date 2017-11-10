package com.lanou.mapper;

import com.lanou.bean.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> findAllSyeuser();

    SysUser findUserById(@Param("id") Integer id);

    //查询三种情况
    List<SysUser> findSysUserByNameAndEmailAndTel(@Param("name")String name,
                                                  @Param("email")String email,
                                                  @Param("tel")String tel);
}
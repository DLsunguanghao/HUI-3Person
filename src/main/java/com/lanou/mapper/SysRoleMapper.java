package com.lanou.mapper;

import com.lanou.bean.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKeyWithBLOBs(SysRole record);

    int updateByPrimaryKey(SysRole record);


    List<SysRole> findAllSysRole();

    SysRole findById(@Param("SId")Integer id);

    List<SysRole> findByName(@Param("name")String name);
}
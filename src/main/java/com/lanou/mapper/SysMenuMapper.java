package com.lanou.mapper;

import com.lanou.bean.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findAllSysMenu();

    SysMenu findMenuById(@Param("id")Integer id);

    SysMenu findMenuByFatherName(@Param("ParentName")String name);
}
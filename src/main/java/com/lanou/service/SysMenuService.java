package com.lanou.service;

import com.lanou.bean.SysMenu;

import java.util.List;

/**
 * Created by yugege on 17/11/10.
 */
public interface SysMenuService {

    List<SysMenu> findAllMenu();

    int addNewMenu(SysMenu sysMenu);

    int updateMenu(SysMenu sysMenu);

    int deleteMenu(Integer id);

    SysMenu findMenuById(Integer id);

    SysMenu findMenuByParentName(String name);
}

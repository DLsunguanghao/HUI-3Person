package com.lanou.service.Impl;

import com.lanou.bean.SysMenu;
import com.lanou.mapper.SysMenuMapper;
import com.lanou.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yugege on 17/11/10.
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper menuMapper;

    @Override
    public List<SysMenu> findAllMenu() {
        return menuMapper.findAllSysMenu();
    }

    @Override
    public int addNewMenu(SysMenu sysMenu) {
        return menuMapper.insertSelective(sysMenu);
    }

    @Override
    public int updateMenu(SysMenu sysMenu) {
        return menuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    @Override
    public int deleteMenu(Integer id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysMenu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }

    @Override
    public SysMenu findMenuByParentName(String name) {
        return menuMapper.findMenuByFatherName(name);
    }
}

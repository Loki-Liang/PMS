package com.cy.pj.sys.service;

import com.cy.pj.sys.pojo.SysMenu;

import java.util.List;

//菜单业务操作的规定义
public interface SysMenuService {
    List<SysMenu> findMens();
}

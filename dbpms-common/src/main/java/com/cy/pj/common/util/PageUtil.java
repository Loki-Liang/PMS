package com.cy.pj.common.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {
    /**
     * 通过此方法启动分页查询
     * @param <T> 这里的 T 为泛型,返回值类型左侧有<T>这种符号的表示方法为泛型方法
     * @return
     */
    public static <T> Page<Object> startPage(){
        HttpServletRequest request= ServletUtil.getRequest();
        //页面大小(每页最多显示多少条记录)
        String pageSizeStr=request.getParameter("pageSize");
        //当前页码值(要查第几页的数据)
        String pageCurrentStr=request.getParameter("pageCurrent");
        System.out.println("pageSize="+pageSizeStr);
        System.out.println("pageCurrent="+pageCurrentStr);
        //在此位置调用 PageHelper 中的一个方法启动分页
        //在项目中去添加一个 PageHelper 依赖(后缀是 starter 的)
        Integer pageCurrent=

                StringUtil.isEmpty(pageCurrentStr)?1:Integer.parseInt(pageCurrentStr);

        Integer pageSize=

                StringUtil.isEmpty(pageSizeStr)?10:Integer.parseInt(pageSizeStr);
        //启动 PageHelper 中的分页拦截器(PageInterceptor)
        return PageHelper.startPage(pageCurrent,pageSize);
    }
}

package com.cy.pj.common.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
/**
 * 定义 spring web 模块中的拦截器，通过此拦截器对 handler 中某些方法的
 * 进行时间访问限制。
 */
@Slf4j //lombok 会在当前 java 文件编译成 class 文件时，会自动在类文件中添加一个 log 对象
public class TimeAccessInterceptor implements HandlerInterceptor {
    // private static final Logger log=
    // LoggerFactory.getLogger(TimeAccessInterceptor.class);
    /**preHandle 方法会在目标 handler 方法执行之前进行访问拦截
     * 方法返回值为 true 时表示请求放行，false 表示请求到此结束，
     * 不再去执行 handler 中的方法
     * */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //testRequestInfo(request,handler);
        LocalTime now=LocalTime.now();//JDK8 中的时间对象
        int hour=now.getHour();//获取当前时间对应小时
        //System.out.println("hour="+hour);
        log.info("hour {}",hour);
        if(hour<=6||hour>=22)
            throw new RuntimeException("请在 6~10 点进行访问");
        return true;
    }
}
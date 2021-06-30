package com.cy.pj.common.web;

import com.cy.pj.common.pojo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ShiroException.class)
    public JsonResult doShiroException(ShiroException e){
        JsonResult r=new JsonResult();
        r.setState(0);
        if(e instanceof UnknownAccountException){
            r.setMessage("用户不存在");
        }else if(e instanceof IncorrectCredentialsException){
            r.setMessage("密码不正确");
        }else if(e instanceof LockedAccountException){
            r.setMessage("账户被锁定");
        }else if(e instanceof AuthorizationException){
            r.setMessage("没有权限");
        }else{
            r.setMessage("认证或授权失败");
        }
        return r;

    }
    public JsonResult doHandleRuntimeException(RuntimeException e){
        log.error("exception{}",e.getMessage());
        e.printStackTrace();
        return new JsonResult();
    }
}

package com.cy.pj.common.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class JsonResult implements Serializable {
    private static final long serialVersionUID =-3616020572486178359L;
    private Integer state=1;
    private String message="Ok";
    private Object data;
    public JsonResult(){}
    public JsonResult(String message){
        this.message=message;
    }
    public JsonResult(Object data){
        this.data=data;
    }
    public JsonResult(Throwable e){
        this.state=0;
        this.message=e.getMessage();
    }

}

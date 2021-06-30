package com.cy.pj.common.exception;

public class ServiceException extends RuntimeException{
    private static final long serialversionUID=-5598865415547474216L;
    public ServiceException(){

    }
    public ServiceException(String messsage){
        super(messsage);
    }
    public ServiceException(Throwable cause){
        super(cause);
    }

}


package com.cy.pj.sys.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data

public class SysMenu implements Serializable {

    private static final long serialVersionUID = -4948259309231173588L;
    private Integer id;
    private String name;
    private String url;
    private Integer type;
    private Integer sort;
    private String note;
    private Integer parentId;
    private String parentName;
    private String permission;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}


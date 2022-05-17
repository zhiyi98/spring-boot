package com.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLog implements Serializable{

	private static final long serialVersionUID = -6309732882044872298L;
	
	private String method;
	private String params;
	private Integer time;
	private String ip;
	private Date createTime;

}

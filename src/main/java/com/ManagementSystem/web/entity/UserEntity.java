package com.ManagementSystem.web.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public String userCode;
	
	public String userName;

	public String password;
	
	public Integer userAuth;
	
	public String authComment;
}

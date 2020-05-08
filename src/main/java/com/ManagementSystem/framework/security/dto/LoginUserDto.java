package com.ManagementSystem.framework.security.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

@Component
@SessionScope
@Getter @Setter
public class LoginUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public String userCode;
	
	public String userName;

	public String password;

	public Integer userAuth;
	
	public String authComment;
}

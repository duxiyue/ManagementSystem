package com.ManagementSystem.web.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Integer authCode;
	
	public String authComment;
}

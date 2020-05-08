package com.ManagementSystem.web.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MenuEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public String menuId;
	
	public String menuName;

	public Integer level;

	public Integer viewOrder;
	
	public Integer authCode;
	
	public String menuCodeMin;
}

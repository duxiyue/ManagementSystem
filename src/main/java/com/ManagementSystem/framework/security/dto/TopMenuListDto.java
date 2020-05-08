package com.ManagementSystem.framework.security.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.ManagementSystem.web.entity.MenuEntity;

import lombok.Getter;
import lombok.Setter;

@Component
@SessionScope
@Getter @Setter
public class TopMenuListDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<MenuEntity> menuList;
	
	public MenuEntity menuEntity;
}

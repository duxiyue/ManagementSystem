package com.ManagementSystem.framework.security.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

@Component
@SessionScope
@Getter @Setter
public class TopMenuDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<TopMenuListDto> topMenuList;
}

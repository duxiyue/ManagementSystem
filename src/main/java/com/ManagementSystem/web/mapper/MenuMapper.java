package com.ManagementSystem.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ManagementSystem.web.entity.MenuEntity;

public interface MenuMapper {

	List<MenuEntity> getMenuList(@Param("level") Integer level,
								 @Param("authCode") Integer authCode,
								 @Param("menuCodeMin") String menuCodeMin);

	MenuEntity getByMenuCode(String menuId);

	void insert(MenuEntity menu);

	void update(MenuEntity menu);

	void delete(String menuId);
}

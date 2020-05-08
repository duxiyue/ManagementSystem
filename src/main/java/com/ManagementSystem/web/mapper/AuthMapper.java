package com.ManagementSystem.web.mapper;

import java.util.List;

import com.ManagementSystem.web.entity.AuthEntity;

public interface AuthMapper {

	List<AuthEntity> getAll();
	
	AuthEntity getByUserCode(Integer authCode);

	void insert(AuthEntity user);

	void update(AuthEntity user);

	void delete(Integer authCode);
}

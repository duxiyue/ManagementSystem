package com.ManagementSystem.web.mapper;

import java.util.List;

import com.ManagementSystem.web.entity.UserEntity;

public interface UserMapper {

	List<UserEntity> getAll();
	
	UserEntity getByUserCode(String userCode);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(String userCode);
}

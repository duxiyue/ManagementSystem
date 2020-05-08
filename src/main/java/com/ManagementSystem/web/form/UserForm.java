package com.ManagementSystem.web.form;

import java.io.Serializable;
import java.util.List;

import com.ManagementSystem.web.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserForm implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<UserEntity> userEntityList;

	public UserEntity userEntity;

	public String password;

	public Integer insertEditFlg;
}

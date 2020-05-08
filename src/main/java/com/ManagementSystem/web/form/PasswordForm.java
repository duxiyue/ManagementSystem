package com.ManagementSystem.web.form;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PasswordForm implements Serializable {

	private static final long serialVersionUID = 1L;

	public String password;
}

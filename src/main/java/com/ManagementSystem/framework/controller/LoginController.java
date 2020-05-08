package com.ManagementSystem.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	/**
	 * ルート
	 * @return ルート
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/**
	 * ログイン画面表示
	 * @return ログイン画面
	 */
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	/**
	 * ログイン画面表示
	 * @return ログイン画面
	 */
	@GetMapping("/top")
	public String top() {
		return "redirect:/notifyView";
	}
}
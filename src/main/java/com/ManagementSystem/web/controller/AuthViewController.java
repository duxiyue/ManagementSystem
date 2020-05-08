package com.ManagementSystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authView")
public class AuthViewController {
	
	/**
	 * 権限管理画面初期処理
	 * @return 権限管理画面
	 */
	@GetMapping("")
	public ModelAndView authView() {
		
		ModelAndView mav = new ModelAndView();
		mav .setViewName("authView");

		return mav;
	}
}
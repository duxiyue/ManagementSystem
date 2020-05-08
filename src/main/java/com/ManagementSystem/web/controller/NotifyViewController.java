package com.ManagementSystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notifyView")
public class NotifyViewController {

	/**
	 * 通知画面初期処理
	 * @return 通知画面
	 */
	@GetMapping("")
	public ModelAndView notifyView() {

		ModelAndView mav = new ModelAndView();
		mav .setViewName("notifyView");

		return mav;
	}
}
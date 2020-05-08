package com.ManagementSystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/workMonthView")
public class WorkMonthViewController {

	/**
	 * 勤怠管理初期処理
	 * @return 勤怠管理画面
	 */
	@GetMapping("")
	public ModelAndView notifyView() {

		ModelAndView mav = new ModelAndView();
		mav .setViewName("workMonthView");

		return mav;
	}
}
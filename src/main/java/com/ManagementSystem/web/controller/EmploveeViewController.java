package com.ManagementSystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emploveeView")
public class EmploveeViewController {

	/**
	 * 自分情報初期処理
	 * @return 自分情報画面
	 */
	@GetMapping("")
	public ModelAndView notifyView() {

		ModelAndView mav = new ModelAndView();
		mav .setViewName("emploveeView");

		return mav;
	}
}
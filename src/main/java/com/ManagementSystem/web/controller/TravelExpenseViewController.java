package com.ManagementSystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/travelExpenseView")
public class TravelExpenseViewController {

	/**
	 * 作業報告書提出画面初期処理
	 * @return 作業報告書提出画面
	 */
	@GetMapping("")
	public ModelAndView travelExpenseView() {

		ModelAndView mav = new ModelAndView();
		mav .setViewName("travelExpenseView");

		return mav;
	}
}
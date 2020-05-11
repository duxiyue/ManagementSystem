package com.ManagementSystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/workTimeReportView")
public class WorkTimeReportViewController {

	/**
	 * 交通費精算書提出画面初期処理
	 * @return 交通費精算書提出画面
	 */
	@GetMapping("")
	public ModelAndView workTimeReportView() {

		ModelAndView mav = new ModelAndView();
		mav .setViewName("workTimeReportView");

		return mav;
	}
}
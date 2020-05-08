package com.ManagementSystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employeeListView")
public class EmployeeListViewController {

	/**
	 * 社員情報一覧初期処理
	 * @return 社員情報一覧画面
	 */
	@GetMapping("")
	public ModelAndView notifyView() {

		ModelAndView mav = new ModelAndView();
		mav .setViewName("employeeListView");

		return mav;
	}
}
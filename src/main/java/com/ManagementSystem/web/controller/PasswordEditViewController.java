package com.ManagementSystem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ManagementSystem.web.form.PasswordForm;
import com.ManagementSystem.web.service.PasswordEditService;

@Controller
@RequestMapping("/passwordEditView")
public class PasswordEditViewController {

	/** パースワード変更サービススクラス */
    @Autowired
    private PasswordEditService passwordEditService;

	/**
	 * パースワード変更画面初期処理
	 * @return パースワード変更画面
	 */
	@GetMapping("")
	public ModelAndView passwordEditViewInit() {

		PasswordForm passwordForm = new PasswordForm();

		ModelAndView mav = new ModelAndView();
		mav.addObject("passwordForm", passwordForm);
		mav.setViewName("passwordEditView");

		return mav;
	}

	/**
	 * ユーザー画面編集処理
	 * @return ユーザー編集画面
	 */
	@PostMapping(value = "/editPassword")
	public ModelAndView editPassword(RedirectAttributes attributes, PasswordForm passwordForm) {

		boolean success = false;
		try {
			// 更新
			success = passwordEditService.passwordUpdate(passwordForm.getPassword());
		} catch (TransactionTimedOutException e) {
			success = false;
    		throw new TransactionTimedOutException("");
    	}

		ModelAndView mav = new ModelAndView();
		mav.addObject("passwordForm", passwordForm);
		mav.setViewName("passwordEditView");

		attributes.addAttribute("success", success);
		return mav;
	}
}
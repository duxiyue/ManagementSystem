package com.ManagementSystem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ManagementSystem.framework.common.util.Messageutil;
import com.ManagementSystem.web.entity.UserEntity;
import com.ManagementSystem.web.form.UserForm;
import com.ManagementSystem.web.service.UserService;
import com.ManagementSystem.web.util.CommonCode;

@Controller
@RequestMapping("/userView")
public class UserViewController {

	/** ユーザーサービスクラス */
    @Autowired
    private UserService userService;

	/**
	 * ユーザー画面初期処理
	 * @return ユーザー画面
	 */
	@GetMapping("")
	public ModelAndView userView() {

		UserForm userForm = new UserForm();

		userForm = userService.userListInit();

		ModelAndView mav = new ModelAndView();
		mav.addObject("userForm", userForm);
		mav.setViewName("userView");

		return mav;
	}

	/**
	 * ユーザー編集処理
	 * @return ユーザー編集画面
	 */
	@GetMapping(value = "/editUser")
	public ModelAndView editUser(@RequestParam("userCode") String userCode) {

		UserForm userForm = new UserForm();
		userForm = userService.userEditInit(userCode);

		userForm.insertEditFlg = CommonCode.EDIT_FLG;

		ModelAndView mav = new ModelAndView();
		mav.addObject("userForm", userForm);
		mav.setViewName("editUserView");

		return mav;
	}

	/**
	 * ユーザー登録処理
	 * @return ユーザー登録画面
	 */
	@GetMapping(value = "/insertUser")
	public ModelAndView insertUser() {

		UserForm userForm = new UserForm();
		userForm.userEntity = new UserEntity();
		userForm.insertEditFlg = CommonCode.NEW_FLG;

		ModelAndView mav = new ModelAndView();
		mav.addObject("userForm", userForm);
		mav.setViewName("editUserView");

		return mav;
	}

	/**
	 * ユーザー登録処理
	 * @return ユーザー画面
	 */
	@PostMapping(value = "/regist")
	public ModelAndView regist(RedirectAttributes attributes, UserForm userForm) {

		ModelAndView mav = new ModelAndView();
		boolean success = false;
		try {
			// 登録処理
			success = userService.userRegist(userForm);

			if (!success) {
				Messageutil.addMessage(mav, "errors.user.exists", CommonCode.EMPTY);
			}

		} catch (TransactionTimedOutException e) {
			success = false;
    	}
		attributes.addAttribute("success", success);
		mav.setViewName("redirect:/userView/insertUser");

		return mav;
	}
}
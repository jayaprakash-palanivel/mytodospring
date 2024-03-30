package com.jp.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jp.todo.bo.LoginBo;
import com.jp.todo.service.AdminService;

@Controller
public class HomeController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "login")
	public ModelAndView getLogin() {
		ModelAndView model = new ModelAndView("login");
		return model;

	}
	@RequestMapping(value = "loginConfirm")
	public ModelAndView postLogin(@ModelAttribute("loginConfirm")LoginBo login) {
		adminService.loginValidate(login.getUserName(),login.getPassword());
		ModelAndView model = new ModelAndView("login");
		return model;

	}

}

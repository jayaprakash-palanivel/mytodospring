package com.jp.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.todo.bo.LoginBo;
import com.jp.todo.dao.AdminDao;
import com.jp.todo.vo.LoginVo;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDao adminDao;

	@Override
	public LoginVo loginValidate(String email,String password) {
	
		return adminDao.loginValidate(email,password);

	}

}

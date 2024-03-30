package com.jp.todo.service;

import com.jp.todo.bo.LoginBo;
import com.jp.todo.vo.LoginVo;

public interface AdminService {

	LoginVo loginValidate(String email,String password);

}

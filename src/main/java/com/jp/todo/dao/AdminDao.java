package com.jp.todo.dao;

import com.jp.todo.vo.LoginVo;

public interface AdminDao {

	LoginVo loginValidate(String email,String password);

}

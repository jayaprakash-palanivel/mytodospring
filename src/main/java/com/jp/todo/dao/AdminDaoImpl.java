package com.jp.todo.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.todo.vo.LoginVo;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public LoginVo loginValidate(String email, String password) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(LoginVo.class);
		cr.add(Restrictions.eq("userName", email));
		cr.add(Restrictions.eq("userName", password));
		LoginVo loginVo=(LoginVo) cr.uniqueResult();
		if(null!=loginVo) {
			return loginVo;
		}
		return null;
	}

}

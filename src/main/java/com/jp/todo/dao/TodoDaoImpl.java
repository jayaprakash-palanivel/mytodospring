package com.jp.todo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.todo.service.TodoService;
import com.jp.todo.vo.TaskVo;
import com.jp.todo.vo.TodoVo;

@Repository
public class TodoDaoImpl implements TodoDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int createTodo(TodoVo todoVo) {
		Session session = sessionFactory.getCurrentSession();
		Long todoId =  (Long) session.save(todoVo);
		if (0 < todoId) {
			return 1;
		}

		return 0;
	}

	@Override
	public List<TodoVo> retriveTodoList() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(TodoVo.class);
		// cr.add(Restrictions.eq("isDelete", false));
		List<TodoVo> listTodo = cr.list();
		if (null != listTodo) {
			return listTodo;
		}
		return null;
	}

}

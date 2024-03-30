package com.jp.todo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.todo.vo.ProjectVo;
import com.jp.todo.vo.TaskVo;
@Repository
public class TaskDaoImpl implements TaskDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public TaskVo createTask(TaskVo taskVo) {
		Session session=sessionFactory.getCurrentSession();
		int taskId=(int) session.save(taskVo);
		if(0<taskId) {
			return taskVo;
		}
		return null;
	}

	@Override
	public List<TaskVo> retriveTaskList() {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(TaskVo.class);
		//cr.add(Restrictions.eq("isDelete", false));
		List<TaskVo> listList=cr.list();
		if(null!=listList) {
			return listList;
		}
		return null;
	}
	
	public TaskVo retriveTask(int taskId) {
		Session session=sessionFactory.getCurrentSession();
		TaskVo taskVo=(TaskVo) session.get(TaskVo.class, taskId);
		if(null!=taskVo) {
			return taskVo;
		}
		return null;
	}

}

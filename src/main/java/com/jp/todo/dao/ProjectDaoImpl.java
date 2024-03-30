package com.jp.todo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.todo.bo.ProjectBo;
import com.jp.todo.vo.ProjectVo;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<ProjectVo> retriveProjectList() {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(ProjectVo.class);
		cr.add(Restrictions.eq("isDelete", false));
		List<ProjectVo> projectList=cr.list();
		if(null!=projectList) {
			return projectList;
		}
		return null;
	}

	@Override
	public int createProject(ProjectVo projectVo) {
		Session session=sessionFactory.getCurrentSession();
		int projectId=(int) session.save(projectVo);
		if(0<projectId) {
			return projectId;
		}
		return 0;
	}

	@Override
	public ProjectVo retriveProjectBasedOnId(int projectId) {
		Session session=sessionFactory.getCurrentSession();
		ProjectVo projectVo=(ProjectVo) session.get(ProjectVo.class, projectId);
		if(null!=projectVo) {
			return projectVo;
		}
		return null;
	}

	@Override
	public int updateProject(ProjectVo projectVo) {
		Session session=sessionFactory.getCurrentSession();
		session.update(projectVo);
		return 0;
	}

	@Override
	public void deleteProject(int projectId) {
		Session session=sessionFactory.getCurrentSession();
		ProjectVo projectVo=(ProjectVo) session.get(ProjectVo.class, projectId);
		if(null!=projectVo) {
			projectVo.setIsDelete(true);
			session.update(projectVo);
		}
	}

}

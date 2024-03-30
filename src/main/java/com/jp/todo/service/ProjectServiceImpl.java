package com.jp.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.todo.bo.ProjectBo;
import com.jp.todo.dao.ProjectDao;
import com.jp.todo.vo.ProjectVo;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectDao projectDao;

	@Override
	public List<ProjectVo> retriveProjectList() {
		// TODO Auto-generated method stub
		return projectDao.retriveProjectList();
	}

	@Override
	public int createProject(ProjectBo projectBo) {
		ProjectVo projectVo = new ProjectVo();
		projectVo.setProjectName(projectBo.getProjectName());
		projectVo.setProjectManager(projectBo.getProjectManager());
		projectVo.setStartDate(projectBo.getStartDate());
		projectVo.setEndDate(projectBo.getEndDate());
		return projectDao.createProject(projectVo);
	}

	@Override
	public ProjectVo retriveProjectBasedOnId(int projectId) {
		return projectDao.retriveProjectBasedOnId(projectId);
	}

	@Override
	public int updateProject(ProjectBo projectBo) {
		ProjectVo projectVo = new ProjectVo();
		projectVo.setProjectId(projectBo.getProjectId());
		projectVo.setProjectName(projectBo.getProjectName());
		projectVo.setProjectManager(projectBo.getProjectManager());
		projectVo.setStartDate(projectBo.getStartDate());
		projectVo.setEndDate(projectBo.getEndDate());
		return projectDao.updateProject(projectVo);
	}

	@Override
	public void deleteProject(int projectId) {
		projectDao.deleteProject(projectId);
		
	}

}

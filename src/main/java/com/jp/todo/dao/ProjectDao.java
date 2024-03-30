package com.jp.todo.dao;

import java.util.List;

import com.jp.todo.bo.ProjectBo;
import com.jp.todo.vo.ProjectVo;

public interface ProjectDao {

	List<ProjectVo> retriveProjectList();

	int createProject(ProjectVo projectVo);

	ProjectVo retriveProjectBasedOnId(int projectId);

	int updateProject(ProjectVo projectVo);

	void deleteProject(int projectId);

}

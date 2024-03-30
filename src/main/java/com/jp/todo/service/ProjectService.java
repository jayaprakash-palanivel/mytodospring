package com.jp.todo.service;

import java.util.List;

import com.jp.todo.bo.ProjectBo;
import com.jp.todo.vo.ProjectVo;

public interface ProjectService {

	List<ProjectVo> retriveProjectList();

	int createProject(ProjectBo projectBo);

	ProjectVo retriveProjectBasedOnId(int projectId);

	int updateProject(ProjectBo projectBo);

	void deleteProject(int projectId);

}

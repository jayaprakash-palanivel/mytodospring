package com.jp.todo.service;

import java.util.List;

import com.jp.todo.bo.TaskBo;
import com.jp.todo.vo.TaskVo;

public interface TaskService {

	int createTask(TaskBo taskBo, int projectId, int employeeId);

	List<TaskVo> retriveTaskList();

}

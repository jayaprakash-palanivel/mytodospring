package com.jp.todo.dao;

import java.util.List;

import com.jp.todo.vo.TaskVo;

public interface TaskDao {

	TaskVo createTask(TaskVo taskVo);

	List<TaskVo> retriveTaskList();
	public TaskVo retriveTask(int taskId);

}

package com.jp.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.todo.bo.TodoBo;
import com.jp.todo.dao.TaskDao;
import com.jp.todo.dao.TodoDao;
import com.jp.todo.vo.TaskVo;
import com.jp.todo.vo.TodoVo;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {
	@Autowired
	TodoDao todoDao;

	@Override
	public int createTodo(TodoBo todoBo, int taskId) {
		TodoVo todoVo = new TodoVo();

		TaskVo task = new TaskVo();
		task.setTaskId(taskId);

		todoVo.setTask(task);
		todoVo.setTitle(todoBo.getTitle());
		todoVo.setDescription(todoBo.getDescription());
		todoVo.setTargetDate(todoBo.getTargetDate());
		todoVo.setStatus(todoBo.isStatus());

		return todoDao.createTodo(todoVo)	;
	}

	@Override
	public List<TodoVo> retriveTodoList() {
		// TODO Auto-generated method stub
		return todoDao.retriveTodoList();
	}

}

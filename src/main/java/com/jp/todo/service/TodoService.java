package com.jp.todo.service;

import java.util.List;

import com.jp.todo.bo.TodoBo;
import com.jp.todo.vo.TodoVo;

public interface TodoService {

	int createTodo(TodoBo todoBo, int taskId);

	List<TodoVo> retriveTodoList();

}

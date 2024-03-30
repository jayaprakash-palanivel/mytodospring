package com.jp.todo.dao;

import java.util.List;

import com.jp.todo.vo.TodoVo;

public interface TodoDao {

	int createTodo(TodoVo todoVo);

	List<TodoVo> retriveTodoList();

}

package com.jp.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.record.formula.functions.Today;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jp.todo.bo.TaskBo;
import com.jp.todo.bo.TodoBo;
import com.jp.todo.service.TaskService;
import com.jp.todo.service.TodoService;
import com.jp.todo.vo.EmployeeVo;
import com.jp.todo.vo.ProjectVo;
import com.jp.todo.vo.TaskVo;
import com.jp.todo.vo.TodoVo;

@Controller
public class TodoController {
	@Autowired
	TaskService taskService;
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value = "createTodo", method = RequestMethod.GET)
	public ModelAndView getCreateTodo() {
		ModelAndView model=new ModelAndView();
		List<TaskVo> taskList = taskService.retriveTaskList();
		model.addObject("todoBo", new TodoBo());
		model.addObject("taskList", taskList);
		model.setViewName("todo-form");
		return model;

	}
	
	
	@RequestMapping(value = { "insert_todo" }, method = RequestMethod.POST)
	public ModelAndView postCreateTask(@ModelAttribute("todoBo") TodoBo todoBo,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("redirect:/listTodo");
		int taskId=Integer.parseInt(request.getParameter("taskId"));
		
		int todoId = todoService.createTodo(todoBo,taskId);
		if (0 < todoId) {
			model.addObject("errorMessage", "Todo Created Successfully!");
		} else {
			model.addObject("errorMessage", "Todo Creation Failed!");
		}
		return model;

	}
	
	@RequestMapping(value = "listTodo")
	public ModelAndView getListTask(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("todo-list");
		if (null != request.getParameter("errorMessage")) {
			model.addObject("errorMessage", request.getParameter("errorMessage"));
		}
		List<TodoVo> listTodo = todoService.retriveTodoList();
		if (null != listTodo && listTodo.size() > 0) {
			model.addObject("listTodo", listTodo);
		} else {
			model.addObject("errorMessage", "No Record Found!");
		}
		return model;

	}
}

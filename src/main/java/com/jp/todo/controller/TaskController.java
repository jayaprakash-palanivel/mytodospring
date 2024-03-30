package com.jp.todo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jp.todo.bo.EmployeeBo;
import com.jp.todo.bo.TaskBo;
import com.jp.todo.service.EmployeeService;
import com.jp.todo.service.ProjectService;
import com.jp.todo.service.TaskService;
import com.jp.todo.vo.EmployeeVo;
import com.jp.todo.vo.ProjectVo;
import com.jp.todo.vo.TaskVo;

@Controller
public class TaskController {
	@Autowired
	TaskService taskService;
	@Autowired
	ProjectService project;
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "createTask", method = RequestMethod.GET)
	public ModelAndView getCreateTask() {
		ModelAndView model = new ModelAndView();
		List<ProjectVo> projectList = project.retriveProjectList();
		List<EmployeeVo> employeeList = employeeService.retriveEmployeeList();
		model.addObject("taskBo", new TaskBo());
		model.addObject("employeeList", employeeList);
		model.addObject("projectList", projectList);
		model.setViewName("task_form");
		return model;

	}

	@RequestMapping(value = { "createTask" }, method = RequestMethod.POST)
	public ModelAndView postCreateTask(@ModelAttribute("taskBo") TaskBo taskBo, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("redirect:/listTask");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		int taskId = taskService.createTask(taskBo, projectId, employeeId);
		if (0 < taskId) {
			model.addObject("errorMessage", "Task Created Successfully!");
		} else {
			model.addObject("errorMessage", "Task Creation Failed!");
		}
		return model;

	}

	@RequestMapping(value = "listTask")
	public ModelAndView getListTask(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("task_list");
		if (null != request.getParameter("errorMessage")) {
			model.addObject("errorMessage", request.getParameter("errorMessage"));
		}
		List<TaskVo> listTask = taskService.retriveTaskList();
		if (null != listTask && listTask.size() > 0) {
			model.addObject("listTask", listTask);
		} else {
			model.addObject("errorMessage", "No Record Found!");
		}
		return model;

	}

}

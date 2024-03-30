package com.jp.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jp.todo.bo.ProjectBo;
import com.jp.todo.service.ProjectService;
import com.jp.todo.vo.ProjectVo;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "listProject")
	public ModelAndView getListProject(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("project_list");
		if (null != request.getParameter("errorMessage")) {
			model.addObject("errorMessage", request.getParameter("errorMessage"));
		}
		List<ProjectVo> listProject = projectService.retriveProjectList();
		if (null != listProject && listProject.size() > 0) {
			model.addObject("listProject", listProject);
		} else {
			model.addObject("errorMessage", "No Record Found!");
		}
		return model;
	}

	@RequestMapping(value = "createProject", method = RequestMethod.GET)
	public String getCreateProject(Model model) {
		model.addAttribute("projectBo", new ProjectBo());
		return "project_form";

	}

	@RequestMapping(value = { "createProject" }, method = RequestMethod.POST)
	public ModelAndView postCreateProject(@ModelAttribute("projectBo") ProjectBo projectBo) {
		ModelAndView model = new ModelAndView("redirect:/listProject");
		int projectId = projectService.createProject(projectBo);
		if (0 < projectId) {
			model.addObject("errorMessage", "Project Created Successfully!");
		} else {
			model.addObject("errorMessage", "Project Creation Failed!");
		}
		return model;

	}

	@RequestMapping(value = "editProject", method = RequestMethod.GET)
	public ModelAndView getEditProject(@RequestParam("projectId") int projectId) {
		ModelAndView model = new ModelAndView("project_form");
		ProjectVo project = projectService.retriveProjectBasedOnId(projectId);
		if (null != project) {
			model.addObject("project", project);
		} else {
			model.addObject("errorMessage", "Project Edit Retrive Failed!");
		}
		return model;

	}

	@RequestMapping(value = "editProject", method = RequestMethod.POST)
	public ModelAndView postEditProject(@ModelAttribute("projectBo") ProjectBo projectBo) {
		ModelAndView model = new ModelAndView();
		projectService.updateProject(projectBo);

		model.addObject("errorMessage", "Project Updated Successfully!");
		model.setViewName("redirect:/listProject");
		return model;

	}

	@RequestMapping(value = "deleteProject", method = RequestMethod.GET)
	public ModelAndView getDeleteProject(@RequestParam("projectId") int projectId) {
		ModelAndView model = new ModelAndView();
		projectService.deleteProject(projectId);

		model.addObject("errorMessage", "Project Deleted Successfully!");
		model.setViewName("redirect:/listProject");
		return model;

	}

}

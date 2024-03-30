package com.jp.todo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.todo.bo.TaskBo;
import com.jp.todo.dao.EmployeeDao;
import com.jp.todo.dao.ProjectDao;
import com.jp.todo.dao.TaskDao;
import com.jp.todo.model.EmailModel;
import com.jp.todo.utils.SendEmailService;
import com.jp.todo.vo.EmployeeVo;
import com.jp.todo.vo.ProjectVo;
import com.jp.todo.vo.TaskVo;
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDao taskDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	SendEmailService sendEmailService;

	EmailModel model=new EmailModel();
	@Override
	public int createTask(TaskBo taskBo, int projectId, int employeeId) {
		TaskVo taskVo = new TaskVo();
		ProjectVo project=new ProjectVo();
		project.setProjectId(projectId);
		EmployeeVo employee=new EmployeeVo();
		employee.setEmployeeId(employeeId);
		
		taskVo.setEmployee(employee);
		taskVo.setProject(project);
		taskVo.setTaskName(taskBo.getTaskName());
		//task.setTaskOwner(taskOwner);
		taskVo.setTaskType(taskBo.getTaskType());
		taskVo.setTaskStatus(taskBo.getTaskStatus());
		taskVo.setStartDate(taskBo.getStartDate());
		taskVo.setEndDate(taskBo.getEndDate());
		TaskVo task = taskDao.createTask(taskVo);
		if(null!=task && 0<task.getTaskId()) {
			employee=employeeDao.retriveEmployeeBasedOnId(employeeId);
			project=projectDao.retriveProjectBasedOnId(projectId);
				String toAddress=employee.getEmailId();
				String bodyContent="Task Assigned";
				String subjects="Task Assign Details";
				model.setTaskName(task.getTaskName());
				model.setProjectName(project.getProjectName());
				model.setStartDate(task.getStartDate());
				model.setEndDate(task.getEndDate());
				model.setUserName(employee.getFirstName());
				model.setEmailId(toAddress);
				String success = sendEmailService.sendTaskAssignEmail(toAddress,bodyContent,subjects,model);
				System.out.println(success);
			
			
		}
		return task.getTaskId();
	}

	@Override
	public List<TaskVo> retriveTaskList() {
		// TODO Auto-generated method stub
		return taskDao.retriveTaskList();
	}

}

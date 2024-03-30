package com.jp.todo.vo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "todos")
public class TodoVo {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "target_date")
	private String targetDate;
	
	@Column(name = "status")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "taskId")
	private TaskVo task;
	
	public TaskVo getTask() {
		return task;
	}

	public void setTask(TaskVo task) {
		this.task = task;
	}

	public TodoVo() {
		
	}
	
	/*
	 * public Todo(long id, String title, String username, String description,
	 * LocalDate targetDate, boolean isDone) { super(); this.id = id; this.title =
	 * title; this.username = username; this.description = description;
	 * this.targetDate = targetDate; this.status = isDone; }
	 * 
	 * public Todo(String title, String username, String description, LocalDate
	 * targetDate, boolean isDone) { super(); this.title = title; this.username =
	 * username; this.description = description; this.targetDate = targetDate;
	 * this.status = isDone; }
	 */	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}

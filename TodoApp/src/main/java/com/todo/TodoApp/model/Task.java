package com.todo.TodoApp.model;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.cglib.core.Local;

public class Task {
	private int task_id;
	private String task_name;
	private int task_status;
	private LocalDate start_date;
	private LocalDate due_date;

	public Task() {
		super();
	}

	public Task(int task_id, String task_name, int task_status, LocalDate start_date, LocalDate due_date) {
		super();
		this.task_id = task_id;
		this.task_name = task_name;
		this.task_status = task_status;
		this.start_date = start_date;
		this.due_date = due_date;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public int getTask_status() {
		return task_status;
	}

	public void setTask_status(int task_status) {
		this.task_status = task_status;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getDue_date() {
		return due_date;
	}

	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_name=" + task_name + ", task_status=" + task_status
				+ ", start_date=" + start_date + ", due_date=" + due_date + "]";
	}

	

}

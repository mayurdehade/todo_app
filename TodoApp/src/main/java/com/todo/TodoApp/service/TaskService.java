package com.todo.TodoApp.service;

import java.util.List;

import com.todo.TodoApp.model.Task;

public interface TaskService {
	
	public List<Task> getAllTask();
	
	public void addTask(Task task);
	
	public void updateTask(Task task);
	
	public void deleteTask(int id);
	
	public Task getTaskById(int id);
}

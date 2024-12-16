package com.todo.TodoApp.dao;

import java.util.List;

import com.todo.TodoApp.model.Task;

public interface TaskDao {
	
	public List<Task> getAllTask();
	
//	public List<Task> getTaskByStatus(int status);
	
	public void addTask(Task task);

	public void updateTask(Task task);
	
	public void deleteTask(int id);
	
	public Task findById(int id);

}

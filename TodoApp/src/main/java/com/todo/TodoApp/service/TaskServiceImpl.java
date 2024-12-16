package com.todo.TodoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.TodoApp.dao.TaskDao;
import com.todo.TodoApp.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

	private TaskDao taskDao;

	@Autowired
	public TaskServiceImpl(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	public List<Task> getAllTask() {
		return taskDao.getAllTask();
	}

//	@Override
//	public List<Task> getTaskByStatus(int status) {
//		return taskDao.getTaskByStatus(status);
//	}

	@Override
	public void addTask(Task task) {
		taskDao.addTask(task);
	}

	@Override
	public void updateTask(Task task) {
		taskDao.updateTask(task);
	}

	@Override
	public void deleteTask(int id) {
		taskDao.deleteTask(id);
	}
	
	public Task getTaskById(int id) {
	    return taskDao.findById(id);
	}

}

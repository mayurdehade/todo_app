package com.todo.TodoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.todo.TodoApp.model.Task;
import com.todo.TodoApp.service.TaskService;

@RestController
public class GetTaskController {
	
	private TaskService taskService;
	
	@Autowired
	public GetTaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable int id) {
	    return taskService.getTaskById(id);
	}
}

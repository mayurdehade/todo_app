package com.todo.TodoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.todo.TodoApp.model.Task;
import com.todo.TodoApp.service.TaskService;

@Controller
public class TaskController {

	private TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/")
	public String getAllTask(Model model) {
		model.addAttribute("allTasks", taskService.getAllTask());
		model.addAttribute("task", new Task());
		return "index";
	}

	@PostMapping("/add")
	public String addTask(@ModelAttribute Task task) {
		taskService.addTask(task);
		return "redirect:/";
	}

	@PostMapping("/delete/{id}")
	public String deleteTask(@PathVariable int id) {
		taskService.deleteTask(id);
		return "redirect:/";
	}

	@PostMapping("/update/{id}")
	public String updateTask(@PathVariable int id, @ModelAttribute Task updatedTask) {

		Task existingTask = taskService.getTaskById(id);

		if (existingTask != null) {
			existingTask.setTask_name(updatedTask.getTask_name());
			existingTask.setTask_status(updatedTask.getTask_status());
			existingTask.setStart_date(updatedTask.getStart_date());
			existingTask.setDue_date(updatedTask.getDue_date());
			taskService.updateTask(existingTask);
		}

		return "redirect:/";
	}

}

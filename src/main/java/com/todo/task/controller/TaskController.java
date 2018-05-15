package com.todo.task.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.todo.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.todo.task.domain.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;


	/**
	 * Get all tasks
	 * 
	 * @return
	 */
	@RequestMapping(path = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Task> getAllTasks() {

		List<Task> tasks = null;

		tasks = taskService.getAllTasks();
		return tasks;
	}

	@RequestMapping(path = "/user/{username}/task", method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean createUserTask(@PathVariable("username") String userName, @RequestBody Task task) {

		return taskService.createTask(task);

	}

	@RequestMapping(path = "/user/{username}/task", method = RequestMethod.PUT, headers = "Accept=application/json")
	public boolean updateUserTask(@PathVariable("username") String userName, @RequestBody Task task) {

		return taskService.updateTask(userName, task);
	}

	@RequestMapping(path = "/user/{username}/task/{taskId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public boolean deleteUserTask(@PathVariable("username") String userName, @PathVariable("taskId") String taskId) {

		return taskService.deleteTask(userName, taskId);
	}

	/**
	 * Get tasks for specific taskid
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/user/{username}/task/{taskId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Task getTaskByTaskId(@PathVariable("username") String userName, @PathVariable("taskId") String taskId) {

		Task taskToReturn = null;

		taskToReturn = taskService.getTaskById(userName, taskId);

		return taskToReturn;
	}

	/**
	 * Get tasks for specific user that is passed in
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/user/{userName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Task> getTasksByUserName(@PathVariable("userName") String userName) {

		List<Task> taskListToReturn = new ArrayList<Task>();
		taskListToReturn = taskService.getTasksForUser(userName);

		return taskListToReturn;
	}
}

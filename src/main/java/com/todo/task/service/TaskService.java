package com.todo.task.service;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.task.respository.TaskRespository;

import com.todo.task.domain.Task;

@Service
public class TaskService {

	@Autowired
	private TaskRespository repository;

	public List<Task> getAllTasks(){

		List<Task> taskList = new ArrayList<Task>();
		Iterable<Task> allTasks = repository.findAll();
		Iterator<Task> taskIterator= allTasks.iterator();

		while(taskIterator.hasNext()){

			Task task  = taskIterator.next();
			taskList.add(task);
		}
		return taskList;
	}

	public Task getTaskById(String username, String taskId){

		Task task = null;

		if(repository.findById(taskId).isPresent()){

			Task currtask = repository.findById(taskId).get();

			if(currtask.getUserName().equalsIgnoreCase(username)){

				task = currtask;
			}
		}
		return task;
	}

	public List<Task> getTasksForUser(String username){

		List<Task> taskList = new ArrayList<Task>();
		Iterable<Task> allTasks = repository.findAll();

		Iterator<Task> taskIterator= allTasks.iterator();

		while(taskIterator.hasNext()){

			Task task  = taskIterator.next();
			if(task.getUserName().equalsIgnoreCase(username)){

				taskList.add(task);

			}
		}
		return taskList;
	}

	public boolean createTask(Task task){

		return (repository.save(task) != null ? true: false);
	}

	public boolean updateTask(String userName, Task task){

		String taskName= task.getTaskName();
		boolean updateSuccess = false;
		Task tobeUpdated = null;

		if(repository.findById(task.getTaskName()).isPresent()){

			tobeUpdated = repository.findById(task.getTaskName()).get();
		}

		if(tobeUpdated != null){

			tobeUpdated.setCompleted(task.isCompleted());
			tobeUpdated.setDescription(task.getDescription());
			updateSuccess = (repository.save(task) != null ? true: false);
		}
		return updateSuccess;
	}

	public boolean deleteTask(String userName, String taskId){

		boolean isDeleteSuccess = false;

		if(repository.findById(taskId).isPresent()){

			Task task = repository.findById(taskId).get();

			if(task.getUserName().equalsIgnoreCase(userName)) {
				repository.delete(task);
				isDeleteSuccess = true;
			}
		}
		return isDeleteSuccess;

	}
}

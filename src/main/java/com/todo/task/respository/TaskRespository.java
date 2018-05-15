package com.todo.task.respository;

import com.todo.task.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskRespository extends CrudRepository<Task, String>{

}

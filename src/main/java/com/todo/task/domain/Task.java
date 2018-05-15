package com.todo.task.domain;

import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

    @Id
    private String taskName;

	/** The last name. */
	private String description;

	/** The completed. */
	private boolean completed;

	/** The user name with whom the task is associated. */
	private String userName;


	/**
	 * Gets the task id.
	 *
	 * @return the task id
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the task id.
	 *
	 * @param taskName the new task id
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Checks if is completed.
	 *
	 * @return true, if is completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * Sets the completed.
	 *
	 * @param completed the new completed
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [taskId=" + taskName + ", description=" + description + ", completed=" + completed + ", userName="
				+ userName + "]";
	}

}

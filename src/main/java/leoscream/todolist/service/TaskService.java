package leoscream.todolist.service;

import leoscream.todolist.model.Task;

import java.util.List;

public interface TaskService
{
	void addTask(Task task);

	void updateTask(Task task);

	void removeTask(int id);

	Task getTaskById(int id);

	List<Task> listTasks();
}

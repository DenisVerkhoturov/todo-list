package leoscream.todolist.service;

import leoscream.todolist.model.Task;
import leoscream.todolist.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService
{
	@Autowired
	private TaskDao taskDao;

	@Override
	@Transactional
	public void addTask(Task task)
	{
		this.taskDao.addTask(task);
	}

	@Override
	@Transactional
	public void updateTask(Task task)
	{
		this.taskDao.updateTask(task);
	}

	@Override
	@Transactional
	public void removeTask(int id)
	{
		this.taskDao.removeTask(id);
	}

	@Override
	@Transactional
	public Number count()
	{
		return this.taskDao.count();
	}

	@Override
	@Transactional
	public Task getTaskById(int id)
	{
		return this.taskDao.getTaskById(id);
	}

	@Override
	@Transactional
	public List<Task> listTasks()
	{
		return this.taskDao.listTasks();
	}

	@Override
	@Transactional
	public List<Task> listTasks(int pageNumber, int perPage)
	{
		return this.taskDao.listTasks(pageNumber * perPage, perPage);
	}
}

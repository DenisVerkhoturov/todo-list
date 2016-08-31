package leoscream.todolist.dao;

import leoscream.todolist.model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao implements TaskDao
{
	private static final Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);

	@Override
	public void addTask(Task task)
	{
		this.persist(task);
		logger.info("Task successfully saved. Task details: " + task);
	}

	@Override
	public void updateTask(Task task)
	{
		this.getSession().update(task);
		logger.info("Task successfully update. Task details: " + task);
	}

	@Override
	public void removeTask(int id)
	{
		Session session = this.getSession();
		Task task = (Task) this.getSession().load(Task.class, id);

		if (task != null) {
			session.delete(task);
		}
		logger.info("Task successfully removed. Task details: " + task);
	}

	public Number count()
	{
		return (Number) this.getSession().createCriteria(Task.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public Task getTaskById(int id)
	{
		Session session = this.getSession();
		Task task = (Task) session.load(Task.class, id);
		logger.info("Task successfully loaded. Task details: " + task);

		return task;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Task> listTasks()
	{
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(Task.class);
		List<Task> taskList = criteria.list();

		for (Task task : taskList) {
			logger.info("Task list: " + task);
		}

		return taskList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Task> listTasks(int offset, int count)
	{
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(Task.class);
		List<Task> taskList = criteria.setFirstResult(offset).setMaxResults(count).list();

		for (Task task : taskList) {
			logger.info("Task list: " + task);
		}

		return taskList;
	}
}

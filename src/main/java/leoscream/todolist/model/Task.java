package leoscream.todolist.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "is_done")
	private boolean done;

	public Task()
	{}

	public Task(String name, String description, boolean done)
	{
		this.name = name;
		this.description = description;
		this.done = done;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public boolean isDone()
	{
		return this.done;
	}

	public void setDone(boolean status)
	{
		this.done = status;
	}

	@Override
	public String toString()
	{
		return "Task{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}

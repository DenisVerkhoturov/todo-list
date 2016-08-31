package leoscream.todolist.dao;

import leoscream.todolist.model.Task;

import java.util.List;

public interface TaskDao
{
    void addTask(Task task);

    void updateTask(Task task);

    void removeTask(int id);

    Number count();

    Task getTaskById(int id);

    List<Task> listTasks();

    List<Task> listTasks(int offset, int count);
}

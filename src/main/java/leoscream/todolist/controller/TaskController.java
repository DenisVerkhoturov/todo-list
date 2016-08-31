package leoscream.todolist.controller;

import org.springframework.ui.Model;
import leoscream.todolist.model.Task;
import leoscream.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class TaskController
{
	private final int TASKS_PER_PAGE = 3;

	@Autowired()
	private TaskService taskService;

	@RequestMapping(value = {"/tasks", "/"}, method = RequestMethod.GET)
	public String listTask(Model model,
	                       @RequestParam(value = "page", required = false, defaultValue = "1") int page)
	{
		model.addAttribute("task", new Task());
		model.addAttribute("tasks", this.taskService.listTasks(page - 1, TASKS_PER_PAGE));
		model.addAttribute("currentPage", page);
		model.addAttribute("pagesCount", Math.ceil((double) this.taskService.count().intValue() / TASKS_PER_PAGE));

		return "list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTask(@ModelAttribute("task") Task task)
	{
		if (task.getId() == 0) {
			this.taskService.addTask(task);
		} else {
			this.taskService.updateTask(task);
		}

		return "redirect:/tasks";
	}

	@RequestMapping("/remove/{id}")
	public String removeTask(@PathVariable("id") int id)
	{
		this.taskService.removeTask(id);

		return "redirect:/tasks";
	}

	@RequestMapping("/edit/{id}")
	public String editTask(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("task", this.taskService.getTaskById(id));
		model.addAttribute("tasks", this.taskService.listTasks());

		return "form";
	}

	@RequestMapping("task/{id}")
	public String taskData(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("task", this.taskService.getTaskById(id));

		return "details";
	}

	@RequestMapping("test")
	public String generateTasks()
	{
		this.taskService.addTask(new Task("30 уровень", "Дойти до 30 уровня на JavaRush", true));
		this.taskService.addTask(new Task("Тестовое задание", "Сделать todo лист по ТЗ из тестового задания", true));
		this.taskService.addTask(new Task("Допуск к реальному проекту", "Заполнить анкету и отправить тестовое задания на проверку в JavaRush", true));
		this.taskService.addTask(new Task("Осенняя стажировка", "Присоедениться к осенней стажировке JavaRush", false));
		this.taskService.addTask(new Task("Реальный проект", "Успешно закончить реальный проект", false));

		return "redirect:/tasks";
	}
}

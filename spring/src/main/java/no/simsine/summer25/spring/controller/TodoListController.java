package no.simsine.summer25.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.simsine.summer25.spring.entity.TodoList;
import no.simsine.summer25.spring.service.TodoListService;

@RestController
@RequestMapping("/todolist")
public class TodoListController {
	
	@Autowired
	private TodoListService remindersService;
	
	@PostMapping
	public TodoList createTodoList(String name) {
		return remindersService.createTodoList(name);
	}
	
	@GetMapping
	public List<TodoList> getTodoLists() {
		return remindersService.getAllTodoLists();
	}
	
	@GetMapping("/{id}")
	public TodoList getTodoListById(@PathVariable Integer id) {
		return remindersService.getTodoListById(id);
	}
	
	@PutMapping("/{id}/name")
	public TodoList updateTodoListName(@PathVariable Integer id, String name) {
		return remindersService.updateTodoList(id, name);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodoList(@PathVariable Integer id) {
		remindersService.deleteTodoList(id);
	}
	
}

package no.simsine.summer25.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotBlank;

import no.simsine.summer25.spring.entity.Todo;
import no.simsine.summer25.spring.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@PostMapping
	public Todo createTodo(@RequestParam(required = true) Integer listId, @RequestParam(required = true) String content) {
		Todo newTodo = todoService.createTodo(listId, content);
		return newTodo;
	}
	
	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable(required = true) Integer id) {
		return todoService.getTodoById(id);
	}
	
	@PutMapping("/{id}/content")
	public Todo updateTodoContent(@PathVariable(required = true) Integer id, @RequestParam @NotBlank String content) {
		return todoService.updateTodoContent(id, content);
	}
	
	@PutMapping("/{id}/finished")
	public Todo updateFinished(@PathVariable(required = true) Integer id) {
		return todoService.toggleFinished(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable(required = true) Integer id) {
		todoService.deleteTodo(id);
	}
}

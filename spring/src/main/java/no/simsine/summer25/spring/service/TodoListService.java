package no.simsine.summer25.spring.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.simsine.summer25.spring.entity.Todo;
import no.simsine.summer25.spring.entity.TodoList;
import no.simsine.summer25.spring.exception.TodoListNotFoundException;
import no.simsine.summer25.spring.repo.TodoListRepo;

@Service
public class TodoListService {
	
	@Autowired
	TodoListRepo todoListRepo;
	
	public List<TodoList> getAllTodoLists() {
		return todoListRepo.findAll();
	}
	
	public TodoList getTodoListById(Integer id) {
		Optional<TodoList> todoListOpt = todoListRepo.findById(id);
		if (todoListOpt.isEmpty()) throw new TodoListNotFoundException(id);
		TodoList todoList = todoListOpt.get();
		todoList.getTodos().sort(Comparator.comparing(Todo::getCreatedAt));
		return todoList;
	}
	
	public TodoList createTodoList(String name) {
		TodoList newReminders = new TodoList(name);
		return todoListRepo.save(newReminders);
	}
	
	public TodoList updateTodoList(Integer id, String newName) {
		TodoList todoList= this.getTodoListById(id);
		todoList.setName(newName);
		return todoListRepo.save(todoList);
	}

	public void deleteTodoList(Integer id) {
		TodoList todoList = this.getTodoListById(id);
		todoListRepo.delete(todoList);
	}
}

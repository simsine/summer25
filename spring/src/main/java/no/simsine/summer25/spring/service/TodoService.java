package no.simsine.summer25.spring.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.simsine.summer25.spring.entity.Todo;
import no.simsine.summer25.spring.exception.TodoNotFoundException;
import no.simsine.summer25.spring.repo.TodoRepo;

@Service
public class TodoService {

	@Autowired
	private TodoRepo todoRepo;
	
	public Todo createTodo(Integer listId, String content) {
		Todo newTodo = new Todo(listId, content);
		return todoRepo.save(newTodo);
	}
	
	public Todo getTodoById(Integer id) throws TodoNotFoundException {
		Optional<Todo> todoOpt = todoRepo.findById(id);
		if (todoOpt.isEmpty()) throw new TodoNotFoundException(id);
		return todoOpt.get();
	}
	
	public Todo updateTodoContent(Integer id, String newContent) {
		Todo todo = this.getTodoById(id);
		todo.setContent(newContent);
		return todoRepo.save(todo);
	}
	
	public void deleteTodo(Integer id) {
		Todo todo = this.getTodoById(id);
		todoRepo.delete(todo);
	}

	public Todo toggleFinished(Integer id) {
		Todo todo = this.getTodoById(id);
		if (todo.getFinishedAt() == null) {
			todo.setFinishedAt(LocalDateTime.now());
		} else if (todo.getFinishedAt() != null) {
			todo.setFinishedAt(null);
		}
		return todoRepo.save(todo);
	}
}

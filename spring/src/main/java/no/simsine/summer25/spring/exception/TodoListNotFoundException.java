package no.simsine.summer25.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TodoListNotFoundException extends ResponseStatusException {
	private static final long serialVersionUID = 1L;

	public TodoListNotFoundException(Integer todoListId) {

		super(HttpStatus.NOT_FOUND, "TodoList with id [" + todoListId+ "] not found");
	}
}

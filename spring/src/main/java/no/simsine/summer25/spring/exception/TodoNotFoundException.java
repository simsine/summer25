package no.simsine.summer25.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TodoNotFoundException extends ResponseStatusException{
	private static final long serialVersionUID = 1L;

	public TodoNotFoundException(Integer todoId) {
		super(HttpStatus.NOT_FOUND, "Todo with id [" + todoId + "] not found");
	}
}

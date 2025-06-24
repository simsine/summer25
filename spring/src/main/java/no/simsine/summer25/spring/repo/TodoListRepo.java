package no.simsine.summer25.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.simsine.summer25.spring.entity.TodoList;

public interface TodoListRepo extends JpaRepository<TodoList, Integer> {
	
}

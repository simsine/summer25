package no.simsine.summer25.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.simsine.summer25.spring.entity.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer> {}

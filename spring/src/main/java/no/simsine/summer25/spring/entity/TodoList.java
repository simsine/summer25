package no.simsine.summer25.spring.entity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(schema = "spring")
public class TodoList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	protected String name;

	@NotNull 
	protected LocalDateTime createdAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "listId")
	protected List<Todo> todos;

	public TodoList() {
		super();
	}

	public TodoList(String name) {
		super();
		this.name = name;
		this.createdAt = LocalDateTime.now();
		this.todos = Collections.emptyList();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
}

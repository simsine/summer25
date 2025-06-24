package no.simsine.summer25.spring.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(schema = "spring")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	protected String content;
	
	@NotNull
	protected LocalDateTime createdAt;
	
	protected LocalDateTime finishedAt;
	
	@NotNull
	protected Integer listId;

	public Todo() {
		super();
	}

	public Todo(@NotNull Integer listId, @NotBlank String content) {
		super();
		this.content = content;
		this.createdAt = LocalDateTime.now();
		this.finishedAt = null;
		this.listId = listId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(LocalDateTime finishedAt) {
		this.finishedAt = finishedAt;
	}

	public Integer getListId() {
		return listId;
	}

	public void setTodoList(Integer listId) {
		this.listId = listId;
	}
}

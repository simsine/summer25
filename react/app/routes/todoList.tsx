import type { FormEvent } from "react";
import { useParams } from "react-router";
import { useTodoList } from "~/queries/useTodoList";
import styled from "styled-components";

const TodoListEntryDiv = styled.div`
	display: flex;
	align-items: center;
	margin-bottom: 1rem;
`

const EntryGroupDiv = styled.div`
	margin: 0;
`

export default function TodoList() {
	let { todoListId = "" } = useParams()

	let id = Number.parseInt(todoListId)

	if (Number.isNaN(id)) throw Error("Invalid id")

	const query = useTodoList(id)

	async function handleDeleteTodo(id: number) {
		const res = await fetch(`/api/todo/${id}`, {
			method: "DELETE",
		})
		if (!res.ok) return Promise.reject(new Error((res.statusText)))
		
		query.refetch()
	}

	async function handleFinished(id: number) {
		const res = await fetch(`/api/todo/${id}/finished`, {
			method: "PUT",
		})
		if (!res.ok) return Promise.reject(new Error((res.statusText)))
		
		query.refetch()
	}

	async function handleCreateTodo(e: FormEvent) {
		e.preventDefault()
		const form = e.currentTarget as HTMLFormElement
		const res = await fetch("/api/todo", {
			method: "POST",
			body: new FormData(form)
		})
		if (!res.ok) return Promise.reject(new Error((res.statusText)))

		form.reset()
		query.refetch()
	}
	
	return <>
		<header className="container">
			<nav>
				<a href="/">&lt; Lists</a>
			</nav>
		</header>
		<main className="container">
			<h1 id="todolist-title">{query.data.name}</h1>
			<hr />
			<section>
				{query.data.todos.map(todo => 
					<TodoListEntryDiv key={todo.id}>
						<input type="radio" checked={todo.finishedAt !== null} readOnly onClick={() => handleFinished(todo.id)} />
						<EntryGroupDiv role="group">
							<input type="text" defaultValue={todo.content} autoComplete="off" readOnly/>
							<input type="button" value="-" className="pico-background-red-450" onClick={() => handleDeleteTodo(todo.id) }/>
						</EntryGroupDiv>
					</TodoListEntryDiv>
				)}
			</section>
			<section>
				<form method="post" onSubmit={handleCreateTodo} >
					<input type="hidden" name="listId" value={query.data.id}/>
					<div role="group" className="flex row-auto">
						<input type="text" name="content" id="content" required autoComplete="off" />
						<input type="submit" value="+" />
					</div>
				</form>
				<a href="#todolist-title">To the top</a>
			</section>
		</main>
	</>
}

import { useRef, type FormEvent } from "react";

import { useTodoLists } from "~/queries/useTodoLists";

export default function App() {
	const query = useTodoLists()

	const createListModal = useRef<HTMLDialogElement>(null)

	async function handleCreateList(e:FormEvent) {
		e.preventDefault()
		const form = e.currentTarget as HTMLFormElement
		const res = await fetch("/api/todolist", {
			method: "POST",
			body: new FormData(form)
		})
		if (!res.ok) return Promise.reject(new Error((res.statusText)))

		query.refetch()
		createListModal.current?.close()
		form.reset()
	}

	return <main className="container">
		<h1>TodoLists</h1>
		{query.data.map(todoList => 
			<a key={todoList.id} href={"/todolist/" + todoList.id} className="contrast">
				<article>
						<span>{todoList.name} ({todoList.todos.length})</span>
				</article>
			</a>
		)}
		<button onClick={() => createListModal.current?.showModal()}>New List</button>
		<form  onSubmit={e => handleCreateList(e)}>
			<dialog ref={createListModal}>
				<article>
					<header>
						<h2>New List</h2>
					</header>
						<input type="text" name="name" id="name" placeholder="List name" required autoComplete="off"/>
					<footer>
						<button className="outline secondary" onClick={() => createListModal.current?.close()}>Cancel</button>
						<button>Create</button>
					</footer>
				</article>
			</dialog>
		</form>
	</main>
	
}

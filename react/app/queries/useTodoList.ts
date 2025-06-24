import { useSuspenseQuery } from "@tanstack/react-query"
import type { TodoList } from "~/types"

async function getTodoList(id: number): Promise<TodoList> {
	const res = await fetch(`/api/todolist/${id}`)
	if (!res.ok) {
		return Promise.reject(new Error((res.statusText)))
	}
	return res.json()
}

export const useTodoList = (id: number) => {
	return useSuspenseQuery<TodoList>({
		queryKey: ["todolist", id],
		queryFn: () => getTodoList(id),
	})
}

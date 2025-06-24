import { useSuspenseQuery } from "@tanstack/react-query"
import type { TodoList } from "~/types"

async function getTodoLists(): Promise<TodoList[]> {
	const res = await fetch("/api/todolist")
	if (!res.ok) {
		return Promise.reject(new Error((res.statusText)))
	}
	return res.json()
}

export const useTodoLists = () => {
	return useSuspenseQuery<Array<TodoList>>({
		queryKey: ["todolists"],
		queryFn: getTodoLists
	})
}

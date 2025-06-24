export type TodoList = {
	id: number;
	name: string;
	createdAt: Date;
	todos: [Todo]
}

export type Todo = {
	id: number;
	content: string;
	createdAt: Date;
	finishedAt: Date|null;
	listId: number;
}

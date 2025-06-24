import { type RouteConfig, index, route } from "@react-router/dev/routes";

export default [
	index("routes/todoLists.tsx"),
	route("todolist/:todoListId", "routes/todoList.tsx"),

] satisfies RouteConfig;

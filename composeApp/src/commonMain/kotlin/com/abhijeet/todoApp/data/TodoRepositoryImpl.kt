package com.abhijeet.todoApp.data

import com.abhijeet.todoApp.data.model.TodoItem
import com.abhijeet.todoApp.domain.TodoRepository

class TodoRepositoryImpl : TodoRepository {

    private val todo = mutableListOf<TodoItem>()
    override suspend fun getAllTodo(): List<TodoItem> {
        return todo.toList()
    }

    override suspend fun addTodo(todo: TodoItem) {
        this.todo.add(todo)
    }

    override suspend fun deleteTodo(todo: TodoItem) {
        this.todo.removeAll { it.id == todo.id }
    }


}
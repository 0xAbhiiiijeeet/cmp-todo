package com.abhijeet.todoApp.domain

import com.abhijeet.todoApp.data.model.TodoItem

interface TodoRepository {
    suspend fun getAllTodo() : List<TodoItem>
    suspend fun addTodo(todo : TodoItem)
    suspend fun deleteTodo(todo: TodoItem)
}
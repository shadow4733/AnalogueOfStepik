package com.course_management_service.service

import com.course_management_service.model.Task
import java.util.*

interface TaskService {
    fun getAllTasksByLesson(lessonId: UUID): List<Task>
    fun getTaskById(taskId: UUID): Task?
    fun createTask(task: Task): Task
    fun updateTask(taskId: UUID, task: Task): Task?
    fun deleteTask(taskId: UUID)
}
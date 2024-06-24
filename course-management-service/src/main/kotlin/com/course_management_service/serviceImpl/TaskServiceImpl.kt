package com.course_management_service.serviceImpl

import com.course_management_service.model.Task
import com.course_management_service.service.TaskService
import java.util.*

class TaskServiceImpl(): TaskService {
    override fun getAllTasksByLesson(lessonId: UUID): List<Task> {
        TODO("Not yet implemented")
    }

    override fun getTaskById(taskId: UUID): Task? {
        TODO("Not yet implemented")
    }

    override fun createTask(task: Task): Task {
        TODO("Not yet implemented")
    }

    override fun updateTask(taskId: UUID, task: Task): Task? {
        TODO("Not yet implemented")
    }

    override fun deleteTask(taskId: UUID) {
        TODO("Not yet implemented")
    }

}
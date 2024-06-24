package com.course_management_service.serviceImpl

import com.course_management_service.dto.request.LessonRequest
import com.course_management_service.dto.response.LessonResponse
import com.course_management_service.model.Lesson
import com.course_management_service.service.LessonService
import java.util.*

class LessonServiceImpl(): LessonService {
    override fun getAllLessonsByCourse(courseId: UUID?): List<LessonResponse?>? {
        TODO("Not yet implemented")
    }

    override fun getLessonById(lessonId: UUID?): LessonResponse? {
        TODO("Not yet implemented")
    }

    override fun createLesson(lessonRequest: LessonRequest?, courseId: UUID?): LessonResponse? {
        TODO("Not yet implemented")
    }

    override fun updateLesson(lessonId: UUID?, lessonRequest: LessonRequest?): LessonResponse? {
        TODO("Not yet implemented")
    }

    override fun deleteLesson(lessonId: UUID?) {
        TODO("Not yet implemented")
    }

}
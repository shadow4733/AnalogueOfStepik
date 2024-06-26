package com.course_management_service.service

import com.course_management_service.dto.request.LessonRequest
import com.course_management_service.dto.response.LessonResponse
import java.util.*


interface LessonService {
    fun getLessonById(lessonId: UUID?): LessonResponse?
    fun createLesson(lessonRequest: LessonRequest, courseId: UUID?): LessonResponse?
    fun updateLesson(lessonId: UUID?, lessonRequest: LessonRequest?): LessonResponse?
    fun deleteLesson(lessonId: UUID?)
}

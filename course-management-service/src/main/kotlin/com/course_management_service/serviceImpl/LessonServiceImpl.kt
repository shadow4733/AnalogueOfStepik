package com.course_management_service.serviceImpl

import com.course_management_service.dto.request.LessonRequest
import com.course_management_service.dto.response.LessonResponse
import com.course_management_service.model.Lesson
import com.course_management_service.repository.CourseRepository
import com.course_management_service.repository.LessonRepository
import com.course_management_service.service.LessonService
import org.springframework.stereotype.Service
import java.util.*

@Service
class LessonServiceImpl(
    private val lessonRepository: LessonRepository,
    private val courseRepository: CourseRepository
) : LessonService {

    override fun getLessonById(lessonId: UUID?): LessonResponse? {
        lessonId ?: return null
        val lesson = lessonRepository.findById(lessonId).orElse(null)
        return lesson?.toResponse()
    }

    override fun createLesson(lessonRequest: LessonRequest, courseId: UUID?): LessonResponse? {
        courseId ?: return null
        val course = courseRepository.findById(courseId).orElse(null) ?: return null
        val lesson = Lesson(
            title = lessonRequest.title,
            description = lessonRequest.description,
            orderIndex = lessonRequest.orderIndex,
            course = course,
            tasks = emptyList(),
            videoUrl = lessonRequest.videoUrl
        )
        val savedLesson = lessonRepository.save(lesson)
        return savedLesson.toResponse()
    }

    override fun updateLesson(lessonId: UUID?, lessonRequest: LessonRequest?): LessonResponse? {
        lessonId ?: return null
        lessonRequest ?: return null
        val lesson = lessonRepository.findById(lessonId).orElse(null) ?: return null
        lesson.title = lessonRequest.title
        lesson.description = lessonRequest.description
        lesson.orderIndex = lessonRequest.orderIndex
        lesson.videoUrl = lessonRequest.videoUrl
        val updatedLesson = lessonRepository.save(lesson)
        return updatedLesson.toResponse()
    }

    override fun deleteLesson(lessonId: UUID?) {
        lessonId ?: return
        lessonRepository.deleteById(lessonId)
    }

    private fun Lesson.toResponse() = LessonResponse(
        lessonId = this.lessonId,
        title = this.title,
        description = this.description,
        orderIndex = this.orderIndex,
        videoUrl = this.videoUrl
    )
}
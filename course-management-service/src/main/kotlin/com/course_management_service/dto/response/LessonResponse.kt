package com.course_management_service.dto.response

import com.course_management_service.model.Lesson
import java.util.*


data class LessonResponse(
    val lessonId: UUID?,
    val title: String,
    val description: String,
    val orderIndex: Int,
    val videoUrl: String?
) {
    companion object {
        fun from(lesson: Lesson): LessonResponse {
            return LessonResponse(
                lessonId = lesson.lessonId,
                title = lesson.title,
                description = lesson.description,
                orderIndex = lesson.orderIndex,
                videoUrl = lesson.videoUrl
            )
        }
    }
}
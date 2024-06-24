package com.course_management_service.dto.response

import java.util.*


@JvmRecord
data class LessonResponse(
    val lessonId: UUID,
    val title: String,
    val content: String
)
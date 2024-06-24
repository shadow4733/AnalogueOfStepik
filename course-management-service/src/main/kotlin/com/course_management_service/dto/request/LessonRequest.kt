package com.course_management_service.dto.request

import java.util.*

data class LessonRequest(
    val lessonId: UUID,
    val title: String,
    val content: String
)
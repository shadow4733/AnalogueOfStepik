package com.course_management_service.dto.request

import java.util.*

data class LessonRequest(
    val title: String,
    val description: String,
    val orderIndex: Int,
    val videoUrl: String
)
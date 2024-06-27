package com.course_management_service.dto.request

import java.util.*

data class CourseCreatedRequest(
    val title: String,
    val keywords: List<String>,
    val description: String,
    val price: Double,
    val author: String,
    val authorId: UUID,
    val coverImageUrl: String
)

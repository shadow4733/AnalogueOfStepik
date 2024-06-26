package com.course_management_service.dto.request

import com.course_management_service.model.Lesson
import java.util.*

data class CourseRequest(
    val title: String,
    val keywords: List<String>,
    val description: String,
    val price: Double,
    val author: String,
    val authorId: UUID,
    val coverImageUrl: String,
)

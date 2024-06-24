package com.course_management_service.dto.response

import java.util.*

data class CourseResponse(
    val courseId: UUID,
    val title: String,
    val keywords: String,
    val description: String,
    val price: Double,
    val author: String,
    val informationAboutAuthor: String,
    val coverImageUrl: String,
    val lessons: List<LessonResponse>
)

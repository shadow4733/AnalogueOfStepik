package com.course_management_service.dto.request

data class CourseRequest(
    val title: String,
    val keywords: String,
    val description: String,
    val price: Double,
    val author: String,
    val informationAboutAuthor: String,
    val coverImageUrl: String,
    val lessons: List<LessonRequest>
)

package com.course_management_service.dto.request

data class UpdateCourseInfoRequest (
    val title: String,
    val keywords: List<String>,
    val description: String,
    val price: Double,
    val author: String,
    val coverImageUrl: String,
)

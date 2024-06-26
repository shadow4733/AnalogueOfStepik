package com.course_management_service.dto.response

import com.course_management_service.model.Course
import java.util.*

data class CourseResponse(
    val courseId: UUID,
    val title: String,
    val keywords: List<String>,
    val description: String,
    val price: Double,
    val author: String,
    val coverImageUrl: String,
    val lessons: List<LessonResponse>
) {
    companion object {
        fun from(course: Course): CourseResponse {
            return CourseResponse(
                courseId = course.courseId,
                title = course.title,
                keywords = course.keywords.toList(), // Convert Set to List
                description = course.description,
                price = course.price,
                author = course.author,
                coverImageUrl = course.coverImageUrl,
                lessons = course.lessons.map { LessonResponse.from(it) }
            )
        }
    }
}
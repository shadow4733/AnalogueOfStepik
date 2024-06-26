package com.course_management_service.service

import com.course_management_service.dto.request.CourseRequest
import com.course_management_service.dto.request.LessonRequest
import com.course_management_service.dto.request.UpdateCourseInfoRequest
import com.course_management_service.dto.response.CourseResponse
import com.course_management_service.dto.response.LessonResponse
import com.course_management_service.model.Course
import com.course_management_service.model.Lesson
import java.util.*


interface CourseService {
    fun addCourseToFavorites(userId: UUID, courseId: UUID)
    fun getFavoriteCourses(userId: UUID): List<CourseResponse>
    fun deleteCourseFromFavorites(userId: UUID, courseId: UUID)
    fun getCourseLessons(courseId: UUID): List<Lesson>?
    fun createCourse(courseRequest: CourseRequest): Course
    fun updateCourseInfo(id: UUID, updateCourseInfoRequest: UpdateCourseInfoRequest): Course?
    fun deleteCourse(id: UUID)
}


package com.course_management_service.service

import com.course_management_service.dto.request.CourseRequest
import com.course_management_service.dto.response.CourseResponse
import java.util.*


interface CourseService {
    fun getAllCourses(): List<CourseResponse?>?
    fun getCourseById(id: UUID?): CourseResponse?
    fun getCoursesByAuthorId(authorId: UUID?): List<CourseResponse?>?
    fun addCourseToFavorites(userId: UUID?, courseId: UUID?)
    fun deleteCourseFromFavorites(userId: UUID?, courseId: UUID?)
    fun createCourse(courseRequest: CourseRequest?): CourseResponse?
    fun updateCourse(id: UUID?, courseRequest: CourseRequest?): CourseResponse?
    fun deleteCourse(id: UUID?)
}


package com.course_management_service.serviceImpl

import com.course_management_service.dto.request.CourseRequest
import com.course_management_service.dto.response.CourseResponse
import com.course_management_service.model.Course
import com.course_management_service.repository.CourseRepository
import com.course_management_service.service.CourseService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseServiceImpl(val courseRepository: CourseRepository): CourseService {

    private val logger = LoggerFactory.getLogger(CourseService::class.java)

    override fun getAllCourses(): List<CourseResponse?>? {
        TODO("Not yet implemented")
    }


    override fun getCourseById(id: UUID?): CourseResponse? {
        TODO("Not yet implemented")
    }

    override fun getCoursesByAuthorId(authorId: UUID?): List<CourseResponse?>? {
        TODO("Not yet implemented")
    }

    override fun addCourseToFavorites(userId: UUID?, courseId: UUID?) {
        TODO("Not yet implemented")
    }

    override fun deleteCourseFromFavorites(userId: UUID?, courseId: UUID?) {
        TODO("Not yet implemented")
    }

    override fun createCourse(courseRequest: CourseRequest?): CourseResponse? {
        TODO("Not yet implemented")
    }

    override fun updateCourse(id: UUID?, courseRequest: CourseRequest?): CourseResponse? {
        TODO("Not yet implemented")
    }

    override fun deleteCourse(id: UUID?) {
        TODO("Not yet implemented")
    }
}
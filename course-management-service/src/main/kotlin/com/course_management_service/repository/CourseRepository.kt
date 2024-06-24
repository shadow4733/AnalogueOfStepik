package com.course_management_service.repository

import com.course_management_service.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CourseRepository: JpaRepository<Course, UUID> {
}
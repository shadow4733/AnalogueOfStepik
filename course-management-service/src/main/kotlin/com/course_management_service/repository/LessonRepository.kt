package com.course_management_service.repository

import com.course_management_service.model.Lesson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LessonRepository : JpaRepository<Lesson, UUID> {
}
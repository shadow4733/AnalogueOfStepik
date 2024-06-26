package com.course_management_service.controller

import com.course_management_service.dto.request.CourseRequest
import com.course_management_service.dto.request.LessonRequest
import com.course_management_service.dto.request.UpdateCourseInfoRequest
import com.course_management_service.dto.response.CourseResponse
import com.course_management_service.dto.response.LessonResponse
import com.course_management_service.model.Course
import com.course_management_service.model.Lesson
import com.course_management_service.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v2")
class CourseController(private val courseService: CourseService) {

    @PostMapping("/favorites/{userId}/{courseId}")
    fun addCourseToFavorites(@PathVariable userId: UUID, @PathVariable courseId: UUID): ResponseEntity<Void> {
        courseService.addCourseToFavorites(userId, courseId)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/favorites/{userId}")
    fun getFavoriteCourses(@PathVariable userId: UUID): ResponseEntity<List<CourseResponse?>> {
        return ResponseEntity.ok(courseService.getFavoriteCourses(userId))
    }

    @GetMapping("/courses/{courseId}/lessons")
    fun getCourseLessons(@PathVariable courseId: UUID): List<Lesson>? {
        return courseService.getCourseLessons(courseId)
    }

    @DeleteMapping("/favorites/{userId}/{courseId}")
    fun deleteCourseFromFavorites(@PathVariable userId: UUID, @PathVariable courseId: UUID): ResponseEntity<Void> {
        courseService.deleteCourseFromFavorites(userId, courseId)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/create")
    fun createCourse(@RequestBody courseRequest: CourseRequest): ResponseEntity<Course> {
        val createdCourse = courseService.createCourse(courseRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse)
    }

    @PutMapping("/update/{id}")
    fun updateCourseInfo(
        @PathVariable id: UUID,
        @RequestBody updateCourseInfoRequest: UpdateCourseInfoRequest
    ): Course? {
        return courseService.updateCourseInfo(id, updateCourseInfoRequest)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteCourse(@PathVariable id: UUID) {
        courseService.deleteCourse(id)
    }
}
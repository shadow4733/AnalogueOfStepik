package com.course_management_service.controller

import com.course_management_service.dto.request.LessonRequest
import com.course_management_service.dto.response.LessonResponse
import com.course_management_service.service.LessonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v3")
class LessonController(
    private val lessonService: LessonService
) {

    @GetMapping("/{lessonId}")
    fun getLesson(@PathVariable lessonId: UUID): ResponseEntity<LessonResponse?> {
        val lesson = lessonService.getLessonById(lessonId)
        return ResponseEntity.ok(lesson)
    }

    @PostMapping("/create/{courseId}")
    fun createLesson(
        @PathVariable courseId: UUID,
        @RequestBody lessonRequest: LessonRequest
    ): ResponseEntity<LessonResponse> {
        val createdLesson = lessonService.createLesson(lessonRequest, courseId)
            ?: return ResponseEntity(HttpStatus.BAD_REQUEST)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLesson)
    }

    @PutMapping("/update/{lessonId}")
    fun updateLesson(
        @PathVariable lessonId: UUID,
        @RequestBody lessonRequest: LessonRequest
    ): ResponseEntity<LessonResponse> {
        val updatedLesson = lessonService.updateLesson(lessonId, lessonRequest)
            ?: return ResponseEntity(HttpStatus.BAD_REQUEST)
        return ResponseEntity.ok(updatedLesson)
    }

    @DeleteMapping("/delete/{lessonId}")
    fun deleteLesson(@PathVariable lessonId: UUID): ResponseEntity<Unit> {
        lessonService.deleteLesson(lessonId)
        return ResponseEntity.noContent().build()
    }
}
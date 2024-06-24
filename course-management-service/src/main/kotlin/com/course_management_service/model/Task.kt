package com.course_management_service.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val taskId: UUID,
    private val title: String,
    private val description: String,
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private val lesson: Lesson

)

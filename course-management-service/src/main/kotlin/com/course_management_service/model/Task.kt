package com.course_management_service.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_id")
    val taskId: UUID,
    @Column(name = "title")
    val title: String,
    @Column(name = "description")
    val description: String,
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    val lesson: Lesson
)

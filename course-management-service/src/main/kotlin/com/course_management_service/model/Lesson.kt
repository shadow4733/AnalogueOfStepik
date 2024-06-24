package com.course_management_service.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "lessons")
data class Lesson(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val lessonId: UUID,
    private val title: String,
    private val description: String,
    private val orderIndex: Int,
    @ManyToOne
    @JoinColumn(name = "course_id")
    private val course: Course,
    @OneToMany(mappedBy = "lesson", cascade = [CascadeType.ALL], orphanRemoval = true)
    private val tasks: List<Task>,
    private val videoUrl: String?
)

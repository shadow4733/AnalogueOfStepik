package com.course_management_service.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "lessons")
data class Lesson(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "lesson_id")
    val lessonId: UUID? = null,
    @Column(name = "title")
    var title: String,
    @Column(name = "description")
    var description: String,
    @Column(name = "order_index")
    var orderIndex: Int,
    @ManyToOne
    @JoinColumn(name = "course_id")
    val course: Course,
    @OneToMany(mappedBy = "lesson", cascade = [CascadeType.ALL], orphanRemoval = true)
    val tasks: List<Task>,
    @Column(name = "video_url")
    var videoUrl: String
)

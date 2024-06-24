package com.course_management_service.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "courses")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val courseId: UUID,
    private val title: String?,
    private val keywords: String,
    private val description: String,
    private val price: Double,
    private val author: String,
    private val informationAboutAuthor: String,
    private val coverImageUrl: String,
    @OneToMany(mappedBy = "course", cascade = [CascadeType.ALL], orphanRemoval = true)
    private val lessons: List<Lesson>
)

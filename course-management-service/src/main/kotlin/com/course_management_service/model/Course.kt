package com.course_management_service.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "courses")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_id")
    val courseId: UUID,
    @Column(name = "title")
    var title: String,
    @Column(name = "keywords")
    var keywords: List<String>,
    @Column(name = "description")
    var description: String,
    @Column(name = "price")
    var price: Double,
    @Column(name = "author")
    var author: String,
    @Column(name = "author_id")
    val authorId: UUID,
    @Column(name = "cover_image_url")
    var coverImageUrl: String,
    @OneToMany(mappedBy = "course", cascade = [CascadeType.ALL], orphanRemoval = true)
    var lessons: List<Lesson>
)

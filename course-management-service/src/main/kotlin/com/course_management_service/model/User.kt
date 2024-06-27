package com.course_management_service.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
data class User(
    @Id
    val userId: UUID,
    val username: String,
    val email: String,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "enrolled_courses", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "course_id")
    val enrolledCourses: MutableSet<UUID> = mutableSetOf(),
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "favorite_courses", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "course_id")
    val favoriteCourses: MutableSet<UUID> = mutableSetOf()
)

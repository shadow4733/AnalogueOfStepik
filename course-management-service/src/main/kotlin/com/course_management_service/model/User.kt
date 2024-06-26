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
    val enrolledCourses: MutableSet<UUID> = mutableSetOf(),
    @ElementCollection(fetch = FetchType.EAGER)
    val favoriteCourses: MutableSet<UUID> = mutableSetOf()
)

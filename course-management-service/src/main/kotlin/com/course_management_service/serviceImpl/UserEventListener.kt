package com.course_management_service.serviceImpl

import com.common.dto.UserRegisteredEvent
import com.course_management_service.model.User
import com.course_management_service.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class UserEventListener(private val userRepository: UserRepository) {
    private val logger = LoggerFactory.getLogger(UserEventListener::class.java)

    @KafkaListener(topics = ["user-registered"], groupId = "course-management-service")
    fun listen(event: UserRegisteredEvent) {
        logger.info("Received event: $event")

        val user = User(
            userId = event.id,
            username = event.username,
            email = event.email
        )
        userRepository.save(user)
    }
}
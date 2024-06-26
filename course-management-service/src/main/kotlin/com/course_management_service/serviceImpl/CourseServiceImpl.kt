package com.course_management_service.serviceImpl

import com.course_management_service.dto.request.CourseRequest
import com.course_management_service.dto.request.UpdateCourseInfoRequest
import com.course_management_service.dto.response.CourseResponse
import com.course_management_service.model.Course
import com.course_management_service.model.Lesson
import com.course_management_service.repository.CourseRepository
import com.course_management_service.repository.UserRepository
import com.course_management_service.service.CourseService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseServiceImpl(
    val courseRepository: CourseRepository,
    val userRepository: UserRepository
) : CourseService {

    private val logger = LoggerFactory.getLogger(CourseService::class.java)

    override fun addCourseToFavorites(userId: UUID, courseId: UUID) {
        logger.info("Adding course with id: {} to favorites for user with id: {}", courseId, userId)

        val user = userRepository.findById(userId)
            .orElseThrow { RuntimeException("User with id $userId not found") }

        if (user.favoriteCourses.contains(courseId)) {
            logger.info("Course with id {} is already in user's favorites", courseId)
            return
        }

        user.favoriteCourses.add(courseId)
        userRepository.save(user)
    }

    override fun getFavoriteCourses(userId: UUID): List<CourseResponse> {
        logger.info("Getting favorite courses for user with id: {}", userId)

        val user = userRepository.findById(userId)
            .orElseThrow { RuntimeException("User with id $userId not found") }

        val favoriteCoursesIds = user.favoriteCourses

        val favoriteCourses = courseRepository.findAllById(favoriteCoursesIds)
            .map { CourseResponse.from(it) }

        return favoriteCourses
    }


    override fun getCourseLessons(courseId: UUID): List<Lesson>? {
        logger.info("Getting course lessons for course with id: {}", courseId)

        return courseRepository.findById(courseId)
            .map { course -> course.lessons }
            .orElse(null)
    }

    override fun deleteCourseFromFavorites(userId: UUID, courseId: UUID) {
        logger.info("Deleting course with id: {} from favorites for user with id: {}", courseId, userId)

        val user = userRepository.findById(userId)
            .orElseThrow { RuntimeException("User with id $userId not found") }

        if (!user.favoriteCourses.contains(courseId)) {
            throw RuntimeException("Course with id $courseId is not in the user's favorites")
        }

        user.favoriteCourses.remove(courseId)
        userRepository.save(user)

        logger.info("Course with id: {} deleted from favorites for user with id: {}", courseId, userId)
    }

    override fun createCourse(courseRequest: CourseRequest): Course {
        logger.info("Creating course: {}", courseRequest)

        val course = Course(
            courseId = UUID.randomUUID(),
            title = courseRequest.title,
            keywords = courseRequest.keywords,
            description = courseRequest.description,
            price = courseRequest.price,
            author = courseRequest.author,
            authorId = courseRequest.authorId,
            coverImageUrl = courseRequest.coverImageUrl,
            lessons = emptyList()
        )

        return courseRepository.save(course)
    }

    override fun updateCourseInfo(id: UUID, updateCourseInfoRequest: UpdateCourseInfoRequest): Course? {
        logger.info("Updating course with id: {}", id)

        return courseRepository.findById(id)
            .map { course ->
                course.title = updateCourseInfoRequest.title
                course.keywords = updateCourseInfoRequest.keywords
                course.description = updateCourseInfoRequest.description
                course.price = updateCourseInfoRequest.price
                course.author = updateCourseInfoRequest.author
                course.coverImageUrl = updateCourseInfoRequest.coverImageUrl

                courseRepository.save(course)
            }
            .orElse(null)
    }

    override fun deleteCourse(id: UUID) {
        logger.info("Deleting course with id: {}", id)

        courseRepository.findById(id)
            .ifPresent { course ->
                courseRepository.delete(course)
            }
    }
}
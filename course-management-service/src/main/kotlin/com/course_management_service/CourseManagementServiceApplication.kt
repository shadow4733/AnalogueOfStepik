package com.course_management_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CourseManagementServiceApplication

fun main(args: Array<String>) {
	runApplication<CourseManagementServiceApplication>(*args)
}

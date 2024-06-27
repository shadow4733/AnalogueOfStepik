package com.course_management_service.redis

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RedisTestServiceTest {

    @Autowired
    private lateinit var redisTestService: RedisTestService

    @Test
    fun testCacheAndRetrieve() {
        // Arrange
        val expectedValue = "testValue"
        redisTestService.cacheTestData()

        // Act
        val actualValue = redisTestService.getTestData()

        // Assert
        assertEquals(expectedValue, actualValue)
    }
}
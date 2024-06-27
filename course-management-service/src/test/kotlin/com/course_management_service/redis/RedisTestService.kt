package com.course_management_service.redis

import jakarta.annotation.PostConstruct
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Service

@Service
class RedisTestService(private val redisTemplate: RedisTemplate<String, String>) {

    private lateinit var valueOps: ValueOperations<String, String>

    @PostConstruct
    private fun init() {
        valueOps = redisTemplate.opsForValue()
    }

    fun cacheTestData() {
        valueOps.set("testKey", "testValue")
    }

    fun getTestData(): String? {
        return valueOps.get("testKey")
    }
}
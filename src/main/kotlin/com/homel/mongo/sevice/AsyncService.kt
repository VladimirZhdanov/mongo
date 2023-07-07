package com.homel.mongo.sevice

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class AsyncService(private val userUpdateService: UserUpdateService) {

    @Async
    fun doTask(name: String) {
        userUpdateService.updateLikes(name)
    }
}

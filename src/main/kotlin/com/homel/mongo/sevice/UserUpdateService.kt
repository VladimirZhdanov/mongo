package com.homel.mongo.sevice

import com.homel.mongo.dao.UserRepository
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserUpdateService(private val repository: UserRepository) {

    @Transactional
    @Retryable(maxAttempts = 10)
    fun updateLikes(name: String) {
        val userEntity = repository.findByName(name)
        userEntity?.let {
            it.likes = it.likes + 1
            repository.save(it)
        }
    }
}
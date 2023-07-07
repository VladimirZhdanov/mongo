package com.homel.mongo.dao

import com.homel.mongo.model.User
import java.util.*
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {

    fun findByName(name: String): User?
}
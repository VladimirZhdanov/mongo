package com.homel.mongo.conroller

import com.homel.mongo.model.User
import com.homel.mongo.sevice.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MongoController(
    private val userService: UserService
) {
    @GetMapping("/generate")
    fun generate(): List<User> {
        return userService.generateUsers()
    }

    @GetMapping("/user")
    fun getUsers(): List<User> {
        return userService.getUsers()
    }

    @GetMapping("/user/{name}")
    fun getUser(@PathVariable name: String): User? {
        return userService.getUser(name)
    }

    @GetMapping("/start")
    fun testLostUpdate(): String {
        userService.doWork("Ann")

        return "work is started"
    }
}

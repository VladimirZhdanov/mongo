package com.homel.mongo.sevice

import com.homel.mongo.dao.CountryRepository
import com.homel.mongo.dao.UserRepository
import com.homel.mongo.model.Country
import com.homel.mongo.model.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val countryRepository: CountryRepository,
    private val asyncService: AsyncService,
) {
    fun getUsers(): List<User> {
        return userRepository.findAll();
    }

    fun getUser(name: String): User? {
        return userRepository.findByName(name)
    }

    @Transactional
    fun generateUsers(): List<User> {

        if (countryRepository.findAll().isEmpty()) {
            countryRepository.save(Country(name = "Russia"))
        }

        if (userRepository.findAll().isEmpty()) {
            userRepository.save(User(name = "Ann", country = countryRepository.findByName("Russia")))
            userRepository.save(User(name = "Ivan"))
            userRepository.save(User(name = "Tor"))
        }

        return userRepository.findAll()
    }

    fun doWork(name: String) {
        for (i in 1 .. 100) {
            asyncService.doTask(name)
        }
    }
}

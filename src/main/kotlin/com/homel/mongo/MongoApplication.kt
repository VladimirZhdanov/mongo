package com.homel.mongo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
@EnableRetry
class MongoApplication

fun main(args: Array<String>) {
	runApplication<MongoApplication>(*args)
}

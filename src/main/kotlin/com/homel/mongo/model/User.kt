package com.homel.mongo.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @Id val id: String? = null,
    val name: String,
    var likes: Int = 0,
    @Version var version: Int? = null,
    val country: Country? = null,
)

@Document
data class Country(
    @Id val id: String? = null,
    val name: String,
)
package com.systemfailed.taskspro.features.auth.data.remote

data class UserEntity(
    val userName: String,
    val name: String,
    val lastName: String,
    val email: String,
    val password: String
)
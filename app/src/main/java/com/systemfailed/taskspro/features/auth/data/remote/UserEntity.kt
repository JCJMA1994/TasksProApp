package com.systemfailed.taskspro.features.auth.data.remote

data class UserEntity(
    val userId: String,
    val userName: String,
    val name: String,
    val lastName: String,
    val email: String,
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "userId" to this.userId,
            "userName" to this.userName,
            "name" to this.name,
            "lastName" to this.lastName,
            "email" to this.email,
        )
    }
}
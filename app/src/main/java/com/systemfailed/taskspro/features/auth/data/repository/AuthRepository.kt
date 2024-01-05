package com.systemfailed.taskspro.features.auth.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.systemfailed.taskspro.features.auth.data.remote.UserEntity
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
) {
    fun doLogin(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }

    //crea al usuario en firebase authertication con el email y el password
    fun doRegister(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    //guarda los datos del usuario en firestore
    fun saveRegister(userName: String, name: String, lastname: String): Task<Void> {
        val user = firebaseAuth.currentUser
        UserEntity(
            userId = user!!.uid,
            userName = userName,
            name = name,
            lastName = lastname,
            email = user.email!!
        )
        return firestore.collection("users").document(user.uid).set(
            UserEntity(
                userId = user.uid,
                userName = userName,
                name = name,
                lastName = lastname,
                email = user.email!!
            ).toMap()
        )
    }

}
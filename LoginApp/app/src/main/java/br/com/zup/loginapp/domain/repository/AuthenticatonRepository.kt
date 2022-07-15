package br.com.zup.loginapp.domain.repository

import br.com.zup.loginapp.constants.TEXT_USER
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.ktx.Firebase

class AuthenticatonRepository {
    private val auth: FirebaseAuth = Firebase.auth
    private val database = FirebaseDatabase.getInstance()
    private val ref = database.getReference("${auth.currentUser?.uid}/$TEXT_USER")

    fun getEmail() : String = auth.currentUser?.email.toString()

    fun register(email: String, password: String) : Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }
    fun login(email: String, password: String) : Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
    }
    fun logout() {
        auth.signOut()
    }

    fun databaseReference() = ref

    fun getUserMessages(): Query{
        return ref.orderByValue()
    }
}
package br.com.zup.loginapp.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.loginapp.constants.ERROR
import br.com.zup.loginapp.constants.SUCCESS
import br.com.zup.loginapp.domain.repository.AuthenticatonRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

class MainViewModel:ViewModel() {
    private val repository = AuthenticatonRepository()

    private val _userText = MutableLiveData<String>()
    val userText: LiveData<String> = _userText

    private val _state = MutableLiveData<String>()
    val state: LiveData<String> = _state

    fun getEmail() = repository.getEmail()

    fun logout() = repository.logout()

    fun sendUserText(text:String){
        repository.databaseReference().setValue(text){ error, ref ->
            if(error != null){
                _state.value = error.message
            }
            _state.value = SUCCESS
        }
    }
    fun getUserText(){
        repository.getUserMessages().addValueEventListener(object: ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val text = dataSnapshot.getValue<String>()
                _userText.value = text
            }

            override fun onCancelled(error: DatabaseError) {
                _state.value = error.message
            }
        })
    }
}
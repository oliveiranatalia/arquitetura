package br.com.zup.meupet.home.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.meupet.NAME_KEY
import br.com.zup.meupet.PREFERENCE_KEY
import br.com.zup.meupet.SAVE_NAME_FLAG_KEY
import br.com.zup.meupet.home.model.MainModel
import br.com.zup.meupet.home.repository.MainRepository

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = MainRepository()

    private val _savedData: MutableLiveData<MainModel> = MutableLiveData()
    val savedData: LiveData<MainModel> = _savedData

    private var _response: MutableLiveData<MainModel> = MutableLiveData()
    val response: LiveData<MainModel> = _response

    private val _savedDataFlag: MutableLiveData<Boolean> = MutableLiveData()
    val savedDataFlag: LiveData<Boolean> = _savedDataFlag

    val pref = application.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)
    val prefEditor = pref.edit()

    fun authentication(pet: MainModel, flagSaveData: Boolean){
        try{
            prefEditor.putBoolean(SAVE_NAME_FLAG_KEY, flagSaveData)
            if(flagSaveData){
                prefEditor.putString(NAME_KEY, pet.name)
                prefEditor.apply()
            }else{
                prefEditor.remove(NAME_KEY)
                prefEditor.apply()
            }
             _response.value = repository.authenticate(pet,getApplication())
        }catch (e:Exception){
            Log.e("Error", "------> ${e.message}")
        }
    }
    fun getDataSaved(){
        try{
            _savedData.value = repository.getDataSaved(getApplication())
            _savedDataFlag.value = pref.getBoolean(SAVE_NAME_FLAG_KEY,false)
        }catch (e:Exception){
            Log.e("Error", "------> ${e.message}")
        }
    }
}
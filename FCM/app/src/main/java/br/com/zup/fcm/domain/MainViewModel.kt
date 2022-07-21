package br.com.zup.fcm.domain

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.lifecycle.AndroidViewModel
import br.com.zup.fcm.data.Notification
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import br.com.zup.fcm.domain.MyFirebaseCloudService.Companion.CURRENT_TOKEN
import br.com.zup.fcm.domain.MyFirebaseCloudService.Companion.NEW_NOTIFICATION
import br.com.zup.fcm.domain.MyFirebaseCloudService.Companion.NOTIFICATION_BODY_KEY
import br.com.zup.fcm.domain.MyFirebaseCloudService.Companion.NOTIFICATION_TITLE_KEY
import br.com.zup.fcm.domain.MyFirebaseCloudService.Companion.TOKEN_KEY

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var _currentToken = MutableLiveData<String>()
    var currentToken: LiveData<String> = _currentToken

    private var _lastNotification = MutableLiveData<Notification>()
    var lastNotification: LiveData<Notification> = _lastNotification

    private var tokenReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            try{
                _currentToken.value = intent?.getStringExtra(TOKEN_KEY).toString()
            }catch(e:Exception){
                e.printStackTrace()
            }
        }
    }

    private var notificationReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            try{
                val title = intent?.getStringExtra(NOTIFICATION_TITLE_KEY).toString()
                val body = intent?.getStringExtra(NOTIFICATION_BODY_KEY).toString()
                val notification = Notification(title,body)
                _lastNotification.value = notification
            }catch(e:Exception){
                e.printStackTrace()
            }
        }
    }

    private var context = application

    init {
        LocalBroadcastManager.getInstance(context).registerReceiver(tokenReceiver,IntentFilter(CURRENT_TOKEN))
        LocalBroadcastManager.getInstance(context).registerReceiver(notificationReceiver, IntentFilter(NEW_NOTIFICATION)
        )
    }
}
package com.msv.appfitplanmobile.screens.login

import androidx.lifecycle.ViewModel
import com.msv.appfitplanmobile.data.local.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    fun setLogin(login:Boolean){
        preferences.setLogin(login)
    }

}
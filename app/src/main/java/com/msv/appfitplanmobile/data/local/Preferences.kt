package com.msv.appfitplanmobile.data.local

import android.content.Context
import android.content.SharedPreferences

class Preferences(
    private val sharedPreferences: SharedPreferences,
) {
    companion object {
        private const val LOGIN = "LOGIN"
    }

    fun setLogin(login:Boolean){
        sharedPreferences.edit().apply {
            putBoolean(LOGIN,login)
        }.apply()
    }

    fun getLogin():Boolean = sharedPreferences.getBoolean(LOGIN, false)

}
package com.example.project.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.example.project.features.signup_activity.domain.data.model.user.User

object SharedPreferences {
    private const val PREFS_NAME = Constants.PREFS_NAME
    private const val KEY_USER = Constants.KEY_USER

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveUser(context: Context, user: User) {
        val editor = getPreferences(context).edit()
        val gson = Gson()
        val json = gson.toJson(user)
        editor.putString(KEY_USER, json)
        editor.apply()
    }

    fun getUser(context: Context): User? {
        val gson = Gson()
        val json = getPreferences(context).getString(KEY_USER, null)
        return gson.fromJson(json, User::class.java)
    }
}
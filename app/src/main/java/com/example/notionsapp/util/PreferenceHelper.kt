package com.example.notionsapp.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {
    private lateinit var sharedPreference: SharedPreferences

    fun unit(context: Context) : PreferenceHelper{
        sharedPreference = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
        return this
    }

    var title: String?
        get()= sharedPreference.getString("title", "")
        set(value) = sharedPreference.edit().putString("title", value)!!.apply()

    var isOnBoardShow: Boolean
        get() = sharedPreference.getBoolean("board", false)
        set(value) = sharedPreference.edit().putBoolean("board", value)!!.apply()
    var isSignedIn: Boolean
        get() = sharedPreference.getBoolean("board", false)
        set(value) = sharedPreference.edit().putBoolean("board", value)!!.apply()

    var isGridLayout: Boolean
        get() = sharedPreference.getBoolean("layout", false)
        set(value) = sharedPreference.edit().putBoolean("layout", value)!!.apply()
}
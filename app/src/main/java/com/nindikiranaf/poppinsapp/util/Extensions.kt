package com.nindikiranaf.poppinsapp.util

import android.content.SharedPreferences
import com.google.gson.Gson

inline fun <reified T> SharedPreferences.getObject(key: String, devValue: T? = null): T?{
    val json = getString(key, null)
    return Gson().fromJson(json, T::class.java) ?: devValue
}

fun SharedPreferences.Editor.putObject(key: String, value: Any?): SharedPreferences.Editor{
    val json =Gson().toJson(value)
    putString(key,json)
    return this
}
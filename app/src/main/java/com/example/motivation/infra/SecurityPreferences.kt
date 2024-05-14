package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {
    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun getString(key: String): String {
        return security.getString(key, "") ?: ""
    }

    fun setString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

}
package br.com.fabio.puppy

import android.content.Context
import android.content.SharedPreferences

object Prefs {

    // retorna o armazém de preferências PREF_ID
    private fun prefs(): SharedPreferences {
        val context = PuppyApplication.getInstance().applicationContext
        return context.getSharedPreferences("Puppy", 0)
    }

    fun setBoolean(flag: String, valor: Boolean) {  prefs().edit().putBoolean(flag, valor).apply()}

    fun getBoolean(flag: String): Boolean {
        return prefs().getBoolean(flag, false)}

    fun setString(flag: String, valor: String) { prefs().edit().putString(flag, valor).apply()}

    fun getString(flag: String): String? {
        return prefs().getString(flag, "")
    }
}
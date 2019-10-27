package br.com.fabio.puppy

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object AtividadeService {

    var host = "https://Fabio87ads.pythonanywhere.com"
    var TAG = "Puppy"

    fun getAtividades (context: Context): List<Atividade> {
        val atividades = mutableListOf<Atividade>()

        var url = "$host/atividades"
        var json = HttpHelper.get(url)
        Log.d(TAG, json)

        return parserJson(json)
    }

    fun save(atividade: Atividade){
        HttpHelper.post("$host/atividades", GsonBuilder().create().toJson(atividade))
    }

    inline fun <reified T> parserJson (json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)

    }
}
package com.widsons.noteapp.model

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

/**
 * Created on : September/27/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : NoteApp
 */
class DataManager(var context : Context) {
    var sharedPreferences : SharedPreferences =
        context.getSharedPreferences("note-pref", Context.MODE_PRIVATE)


    var dataCache : MutableList<NoteData> = ArrayList()

    fun insert(data: NoteData) {
        dataCache.add(data)
        sharedPreferences.edit().putString("data-note",
            GsonBuilder().create().toJson(dataCache)).apply()
    }

    fun delete(index : Int) {
        dataCache.removeAt(index)
        sharedPreferences.edit()
            .putString("data-note", GsonBuilder().create()
                .toJson(dataCache)).apply()
    }

    fun findAll() : MutableList<NoteData> {

        var jsonData = sharedPreferences.getString("data-note", "")

        if(jsonData == "") {
            dataCache = ArrayList()
        }
        else {
            dataCache = GsonBuilder().create().fromJson(jsonData,
                object : TypeToken<MutableList<NoteData>>(){}.type)
        }

        return dataCache
    }

    fun countTotal() : Double{
        var total = 0.0
        for(data in dataCache) {
            if(data.isIncome) {
                total += data.money
            }
            else {
                total -= data.money
            }
        }
        return total
    }
}


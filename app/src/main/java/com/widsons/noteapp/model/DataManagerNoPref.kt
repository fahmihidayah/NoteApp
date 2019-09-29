package com.widsons.noteapp.model

/**
 * Created on : September/29/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : NoteApp
 */
class DataManagerNoPref {
    var dataCache : MutableList<NoteData> = mutableListOf(
        NoteData("Pemasukan", 10000.0, true),
        NoteData("Jajan", 100.0, false),
        NoteData("Dikasih teman", 5000.0, true)
    )

    fun insert(noteData: NoteData) {
        dataCache.add(noteData)
    }

    fun deleteAt(index : Int) {
        dataCache.removeAt(index)
    }

    fun findAll() = dataCache

    fun countTotal() : Double {
        var total : Double = 0.0
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
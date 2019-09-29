package com.widsons.noteapp.activity.test_generic

/**
 * Created on : September/29/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : NoteApp
 */
class PrintHelper<T>(var data : T ) {


    fun printNow() {
        println("data is ${data}")
    }
}
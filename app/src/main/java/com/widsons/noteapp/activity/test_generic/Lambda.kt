package com.widsons.noteapp.activity.test_generic

import android.app.Activity
import android.view.View
import android.widget.Button

/**
 * Created on : September/29/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : NoteApp
 */

class Lambda : Activity(){
    fun test() {
        var onClickCustom : (Int, String) -> Unit = { parameterPertama, stringKedua ->


        }

        onClickCustom(10, "fahmi")
    }
}
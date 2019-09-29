package com.widsons.noteapp.activity.test_generic

import com.widsons.noteapp.model.NoteData

/**
 * Created on : September/29/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : NoteApp
 */
class GunakanPrint {

    fun print() {
        var printHelper : PrintHelper<String> = PrintHelper("Fahmi")
        var printHelperInt : PrintHelper<Int> = PrintHelper(1)
        var printHelperNote : PrintHelper<NoteData> = PrintHelper(NoteData("tedt", 1.0, true))
    }
}
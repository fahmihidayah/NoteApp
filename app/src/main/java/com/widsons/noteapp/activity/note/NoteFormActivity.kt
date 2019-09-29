package com.widsons.noteapp.activity.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.widsons.noteapp.R
import com.widsons.noteapp.model.DataManager
import com.widsons.noteapp.model.NoteData
import kotlinx.android.synthetic.main.activity_note_form.*

class NoteFormActivity : AppCompatActivity() {

    lateinit var dataManager : DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_form)

        dataManager = DataManager(this)

        button_pemasukan.setOnClickListener {
            dataManager.insert(
                NoteData(edit_text_note.text.toString(),
                    edit_text_money.text.toString().toDouble(),
                    true
                    )
            )
        }

        button_pengeluaran.setOnClickListener {
            dataManager.insert(
                NoteData(edit_text_note.text.toString(),
                    edit_text_money.text.toString().toDouble(),
                    false
                )
            )
        }
    }
}

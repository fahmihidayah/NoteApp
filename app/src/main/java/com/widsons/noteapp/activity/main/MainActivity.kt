package com.widsons.noteapp.activity.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.widsons.noteapp.R
import com.widsons.noteapp.activity.note.NoteFormActivity
import com.widsons.noteapp.model.DataManager
import com.widsons.noteapp.model.DataManagerNoPref
import com.widsons.noteapp.model.NoteData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter : NoteAdapter = NoteAdapter()

    lateinit var dataManager : DataManagerNoPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataManager = DataManagerNoPref()

        recycler_view_note.adapter = adapter

        adapter.onDeleteNote = {position ->
            dataManager.deleteAt(position)
            adapter.notifyDataSetChanged()
        }

        button_tambah.setOnClickListener {

        }
    }

    override fun onStart() {
        super.onStart()
        adapter.datas = dataManager.findAll()
        text_view_total.setText("Total : ${dataManager.countTotal()}")
    }

    fun testShared() {
        var sharedpref = getSharedPreferences("note-app", Context.MODE_PRIVATE)
        sharedpref.edit().putString("key", "value").apply()
    }
}

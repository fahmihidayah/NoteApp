package com.widsons.noteapp.activity.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.widsons.noteapp.R
import com.widsons.noteapp.activity.note.NoteFormActivity
import com.widsons.noteapp.model.DataManager
import com.widsons.noteapp.model.NoteData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter : NoteAdapter = NoteAdapter()

    lateinit var dataManager : DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataManager = DataManager(this)

//        recycler_view_note.layoutManager = LinearLayoutManager(this)
        recycler_view_note.adapter = adapter
        adapter.deleteAction = { i ->
            dataManager.delete(i)
            adapter.datas = dataManager.findAll()
        }

        button_tambah.setOnClickListener {
            startActivity(Intent(this, NoteFormActivity::class.java))
        }

        button_tambah.callOnClick()
    }

    override fun onStart() {
        super.onStart()
        adapter.datas = dataManager.findAll()
        text_view_total.setText("Total : ${dataManager.countTotal()}")
    }
}

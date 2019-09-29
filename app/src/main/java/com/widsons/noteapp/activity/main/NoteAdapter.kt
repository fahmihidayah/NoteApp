package com.widsons.noteapp.activity.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.widsons.noteapp.R
import com.widsons.noteapp.model.NoteData
import kotlinx.android.synthetic.main.item_note_layout.view.*

/**
 * Created on : September/27/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : NoteApp
 */
class NoteAdapter : RecyclerView.Adapter<NoteDataViewHolder>() {

    var datas : MutableList<NoteData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteDataViewHolder {
        return NoteDataViewHolder(
           LayoutInflater
               .from(parent.context)
               .inflate(R.layout.item_note_layout,
                   parent,
                   false)
        )
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: NoteDataViewHolder, position: Int) {
        holder
            .itemView
            .text_view_note
            .setText(datas[position].note)
        holder
            .itemView
            .text_view_money
            .setText(datas[position].money.toString())
    }

}
package com.example.notesapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.notesapp.Entity.Notes_Entity
import com.example.notesapp.databinding.NotesItemBinding

class NotesAdapter(notes: List<Notes_Entity>) : Adapter<NotesAdapter.Notesholder>(){

    var notes = notes

    class Notesholder(itemview: NotesItemBinding):ViewHolder(itemview.root){
    var binding = itemview


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Notesholder {
        var  binding = NotesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  Notesholder(binding )
    }

    override fun getItemCount(): Int {
        return notes.size



    }

    override fun onBindViewHolder(holder: Notesholder, position: Int) {
       holder.binding.apply {
           notes.get(position).apply{
               txtTitle.text = title
               txtText.text = note
               txtDate.text = data

           }

       }
    }

    fun update(notes: List<Notes_Entity>) {

        this.notes = notes
        notifyDataSetChanged()
    }

}

package com.example.notesapp.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notesapp.Entity.Notes_Entity

@Dao
interface NotesDao {

    @Insert
    fun addnote (noteEntity: Notes_Entity)


    @Query("SELECT * From notes")
    fun getnotes(): List<Notes_Entity>

    @Delete
    fun deletnote(noteEntity: Notes_Entity)

    @Query("DELETE FROM notes")
    fun alldelete()

}

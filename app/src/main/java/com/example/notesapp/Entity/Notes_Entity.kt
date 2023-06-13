package com.example.notesapp.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class Notes_Entity(
    @ColumnInfo(name ="Title") var title:String,
    @ColumnInfo(name = "text") var note: String,
    @ColumnInfo(name = "data") var data: String,
    @ColumnInfo(name = "colour") var colour: Int,

    ){
    @PrimaryKey (autoGenerate = true) var id:Int = 0
}

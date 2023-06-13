package com.example.notesapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notesapp.Adapter.NotesAdapter
import com.example.notesapp.Database.RoomDB
import com.example.notesapp.Entity.Notes_Entity
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.databinding.AddDialogBinding
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
//    lateinit var db: RoomDB
//    lateinit var binding: ActivityMainBinding
//    lateinit var adapter : NotesAdapter

    lateinit var db: RoomDB
    lateinit var binding : ActivityMainBinding
    lateinit var adapter: NotesAdapter
    var color = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomDB.init(this)

        initView()

    }

    private fun initView() {
        binding.add.setOnClickListener {
            addNoteDilog()
        }


            adapter = NotesAdapter(db.note().getnotes())
            binding.notelist.layoutManager = StaggeredGridLayoutManager( 2,StaggeredGridLayoutManager.VERTICAL)
            binding.notelist.adapter = adapter


    }

    private fun addNoteDilog() {
        var dialog = Dialog(this)
        var bind = AddDialogBinding.inflate(layoutInflater)
        dialog.setContentView(bind.root)


        bind.btnsubmit.setOnClickListener {
            var title = bind.editTitle.text.toString()
            var note = bind.editText.text.toString()
            var formate = SimpleDateFormat("dd/MM/yyyy hh,mm")
            var currect = formate.format(Date())
            var data = Notes_Entity(title, note, currect, color)


            db.note().addnote(data)
            adapter.update(db.note().getnotes())


            bind.btncolour.setOnClickListener {
                MaterialColorPickerDialog
                    .Builder(this)        					// Pass Activity Instance
                    .setTitle("Pick Theme")           		// Default "Choose Color"
                    .setColorShape(ColorShape.SQAURE)   	// Default ColorShape.CIRCLE
                    .setColorSwatch(ColorSwatch._300)   	// Default ColorSwatch._500
                    // Pass Default Color
                    .setColorListener { color, colorHex ->

                        this.color = color
                    }
                    .show()
            }





            dialog.dismiss()
        }

        dialog.show()
    }




}

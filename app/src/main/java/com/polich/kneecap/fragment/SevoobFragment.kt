package com.polich.kneecap.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.fragment.app.Fragment

import com.polich.kneecap.*
import com.polich.kneecap.data.Plants.cultures
import com.polich.kneecap.data.Plants.plants


class SevoobFragment : Fragment() {
//    var current_level= mutableListOf<Event>()
//    var current_level_left = current_level
//    var current_good_answer = mutableSetOf<MethodsStruggle>()
//    var current_bad_answer = mutableSetOf<MethodsStruggle>()
val selectedItems = ArrayList<Int>()
var textsev = "Выберете культуру"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sevoob, container, false)
        val sevoobselect : TextView = view.findViewById(R.id.text_select_sevoob)
        val btnsevo1 : Button = view.findViewById(R.id.button)

btnsevo1.setOnClickListener(){
    onCreateDialog().show()
    btnsevo1.isClickable = false
}

//            sevoobselect.text = selectedItems.toString()


        return view
    }



    fun onCreateDialog(): Dialog {
        return activity?.let {


             // Where we track the selected items
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Выберите культуру")
                .setSingleChoiceItems(plants, -1
                ) { dialog, item ->
                    selectedItems.add(item)

                }
                .setPositiveButton("OK"
                ) { dialog, id ->
                    // User clicked OK, so save the selectedItems results somewhere
                    // or return them to the component that opened the dialog

                }
                .setNegativeButton("Отмена") {
                        dialog, id ->
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}














package com.polich.kneecap.adapters

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.polich.kneecap.R
import com.polich.kneecap.data.Plants
import com.polich.kneecap.data.Sevoob.addButtonClicked
import com.polich.kneecap.data.Sevoob.culturesChosen

class SevoobRecyclerViewAdapter(var fragment:Fragment, private val values: List<String>) :
    RecyclerView.Adapter<SevoobRecyclerViewAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.sevoob_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBing(position)
        holder.cultureNumberTextView.text = (position+1).toString()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var selectedCulture:TextView = itemView.findViewById(R.id.textView_selected_sevoob)
        var cultureNumberTextView:TextView = itemView.findViewById(R.id.cultureNumberTextView)
        var addButton: Button = itemView.findViewById(R.id.addToSevoob)
        var helpButton:ImageView = itemView.findViewById(R.id.helpImageView)

        val selectedItems = ArrayList<Int>()
        fun onBing(position: Int){
            addButton.setOnClickListener {
                if (!addButtonClicked){
                    var checkedItem = 1
                    var builder = AlertDialog.Builder(fragment.requireContext())
                    builder.setTitle("Выберите культуру")
                        .setSingleChoiceItems(Plants.plants, checkedItem) { dialog, item ->
                            checkedItem = item
                        }
                        .setPositiveButton("OK"
                        ) { dialog, which ->
                            addButtonClicked = true
                            addButton.text = "-"
                            helpButton.visibility = VISIBLE
                            selectedCulture.text = Plants.plants[checkedItem]
                            culturesChosen++
                        }
                        .setNegativeButton("Отмена") {
                                dialog, id ->
                        }
                    val dialog = builder.create()
                    dialog.show()
                }
                else {
                    addButtonClicked = false
                    helpButton.visibility = INVISIBLE
                    addButton.text = "+"
                    selectedCulture.text = "Выберите растение"
                }
            }
            helpButton.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("key", "URL_PLANTED")
                bundle.putString("URL_PLANTED", itemView.resources.getString(R.string.url_culture))
                itemView.findNavController().navigate(R.id.action_eventFragment_to_webFragment, bundle)
            }
        }
    }
}
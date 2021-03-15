package com.polich.kneecap.adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.R
import com.polich.kneecap.data.Plants
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

        val selectedItems = ArrayList<Int>()
        fun onBing(position: Int){
            addButton.setOnClickListener {
                var checkedItem = 1
                var builder = AlertDialog.Builder(fragment.requireContext())
                builder.setTitle("Выберите культуру")
                    .setSingleChoiceItems(Plants.plants, checkedItem) { dialog, item ->
                        checkedItem = item
                    }
                    .setPositiveButton("OK"
                    ) { dialog, which ->
                        selectedCulture.text = Plants.plants[checkedItem]
                        culturesChosen++
                    }
                    .setNegativeButton("Отмена") {
                            dialog, id ->
                    }
                val dialog = builder.create()
                dialog.show()
            }
        }
    }
}
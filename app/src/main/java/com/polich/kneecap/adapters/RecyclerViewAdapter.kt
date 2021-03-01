package com.polich.kneecap.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.polich.kneecap.R

class MyRecyclerViewAdapter(var fragment: Fragment, data: ArrayList<String>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.DataViewHolder>() {

    val mData = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_level, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.onBing(mData[position])
        //holder.title.text = mData[position]
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class DataViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        var card: MaterialCardView = itemView.findViewById(R.id.item_level)
        var title: TextView = itemView.findViewById(R.id.info_text)

        fun onBing(data: String){
            title.text = "Уровень ${data}"
            card.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("POLE", data)
                fragment.requireActivity().findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.action_levelSelectionFragment_to_gameFragment, bundle)
            }
        }

    }

    fun getItem(id: Int): String {
        return mData[id]
    }

}
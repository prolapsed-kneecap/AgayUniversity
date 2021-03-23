package com.polich.kneecap.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.CultureSelectListener
import com.polich.kneecap.R
import com.polich.kneecap.data.Plants

class SpinnerRecyclerView(var fragment: Fragment, private val values: List<String>) :
    RecyclerView.Adapter<SpinnerRecyclerView.NewViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewViewHolder {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.spinner_item, parent, false)
        return NewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        holder.onBing(position)
    }

    inner class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var spinner = itemView.findViewById<Spinner>(R.id.simple_spinner)
        lateinit var spinnerArrayAdapter:ArrayAdapter<Int>
        var boronaArray = arrayOf(R.array.Борона)
        var seyalkiArray = arrayOf(R.array.Сеялки)
        var combineArray = arrayOf(R.array.Комбайны)
        @SuppressLint("ResourceType")

        fun onBing(position: Int) {
            when(position){
                0->spinnerArrayAdapter = ArrayAdapter(itemView.context,android.R.layout.simple_spinner_dropdown_item, seyalkiArray)
                1->spinnerArrayAdapter = ArrayAdapter(itemView.context,android.R.layout.simple_spinner_dropdown_item, seyalkiArray)
                2->spinnerArrayAdapter = ArrayAdapter(itemView.context,android.R.layout.simple_spinner_dropdown_item, seyalkiArray)
            }
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = spinnerArrayAdapter
            spinner.onItemClickListener = object : AdapterView.OnItemSelectedListener,
                AdapterView.OnItemClickListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}

                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }
            }
            spinnerArrayAdapter
        }
    }
}
package com.polich.kneecap.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.CategorySelectListener
import com.polich.kneecap.InstrumentSelectListener
import com.polich.kneecap.R
import com.polich.kneecap.data.InstrumentFragment.isInstrumentSelection
import com.polich.kneecap.data.InstrumentFragment.selectedCategory
import com.polich.kneecap.data.InstrumentFragment.selectedInstrument

class SpinnerRecyclerViewAdapter(var fragment: Fragment, private val values: List<String>,
                                 private val categorySelectListener: CategorySelectListener,
                                 private val instrumentSelectListener: InstrumentSelectListener) :
    RecyclerView.Adapter<SpinnerRecyclerViewAdapter.NewViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewViewHolder {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.instruments_item, parent, false)
        return NewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        if (isInstrumentSelection)
            holder.onBingInstruments(position)
        else
            holder.onBing(position)
    }

    inner class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var spinnerArrayAdapter:ArrayAdapter<Int>
        var boronaArray = arrayOf(R.array.Борона)
        var seyalkiArray = arrayOf(R.array.Сеялки)
        var combineArray = arrayOf(R.array.Комбайны)
        var categories = arrayOf("Сеялки","Комбайны","Бороны","Бороны","Бороны","Бороны","Бороны")
        var instruments = arrayOf("Сеялка 1", "Комбайн 1", "Борона 1", "Борона 1", "Борона 1", "Борона 1", "Борона 1")
        var instrumentTextView = itemView.findViewById<TextView>(R.id.instrumentTextView)

        @SuppressLint("ResourceType")
        fun onBing(position: Int) {
            instrumentTextView.text = categories[position]
            instrumentTextView.setOnClickListener {
                selectedCategory=categories[position]
                categorySelectListener.onCategorySelected()
            }
        }
        fun onBingInstruments(position: Int){
            selectedInstrument=instruments[position]
            instrumentTextView.setOnClickListener {
                instrumentTextView.text = instruments[position]
                instrumentSelectListener.onInstrumentSelected()
            }
        }
    }
}
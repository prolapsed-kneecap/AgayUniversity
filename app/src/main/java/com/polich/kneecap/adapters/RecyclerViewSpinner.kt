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
        lateinit var itemView:View
        if (isInstrumentSelection)
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.instruments_item,parent,false)
        else
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.category_item,parent,false)
        return NewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        if (isInstrumentSelection)
            holder.onBingInstruments(position)
        else
            holder.onBingCategory(position)
    }

    inner class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var spinnerArrayAdapter:ArrayAdapter<Int>
       /* var boronaArray = arrayOf(R.array.Борона)
        var seyalkiArray = arrayOf(R.array.Сеялки)
        var combineArray = arrayOf(R.array.Комбайны)*/
        var boroni = arrayOf("Бороны", "", "", "", "", "", "", "", "")
        var seyalki = arrayOf("Сеялки", "", "", "", "", "", "", "", "")
        var combines = arrayOf("Комбайны", "", "", "", "", "", "", "", "")

        var categories = arrayOf("Сеялки","Комбайны","Бороны","Бороны","Бороны","Бороны","Бороны")
        var instrumentTextView = itemView.findViewById<TextView>(R.id.instrumentsTextView)
        var categoriesTextView = itemView.findViewById<TextView>(R.id.categoriesTextView)

        @SuppressLint("ResourceType")
        fun onBingCategory(position: Int) {
            categoriesTextView.text = categories[position]
            categoriesTextView.setOnClickListener {
                selectedCategory = categories[position]
                isInstrumentSelection=true
                categorySelectListener.onCategorySelected()
            }
        }
        fun onBingInstruments(position: Int){
            if (selectedCategory=="Сеялки")
                instrumentTextView.text = seyalki[position]
            else if (selectedCategory=="Бороны")
                instrumentTextView.text = boroni[position]
            else if (selectedCategory=="Комбайны")
                instrumentTextView.text = combines[position]
            
            instrumentTextView.setOnClickListener {
                isInstrumentSelection=false
                instrumentSelectListener.onInstrumentSelected()
            }
        }
    }
}
package com.polich.kneecap.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.polich.kneecap.NaturalDisasters
import com.polich.kneecap.R

class EventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)

        //val naturalDisasters = NaturalDisasters()
        //val oneEvant = naturalDisasters.naturalEventForLevel[1]

        return view
    }
}
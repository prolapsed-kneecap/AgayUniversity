package com.polich.kneecap

import com.polich.kneecap.data.Culture
import com.polich.kneecap.data.Plants.cultures

class PlantMaster {

    private val positiveMap = mutableMapOf<Culture, List<Culture>>(
        cultures[0] to listOf(cultures[1], cultures[2]),
        cultures[1] to listOf(cultures[0], cultures[2]),
        cultures[2] to listOf(cultures[1], cultures[0]),
        cultures[3] to listOf(cultures[1], cultures[0]),
        cultures[4] to listOf(cultures[1], cultures[0])
    )

    fun howIsGoodChoice(prev : Culture, next : Culture) : Int{
        val isGoodNext = positiveMap[prev]?.contains(next) ?: false
        return if (isGoodNext)
            250
        else
            10
    }
}

enum class Rate{
    RIGHT,
    WRONG
}
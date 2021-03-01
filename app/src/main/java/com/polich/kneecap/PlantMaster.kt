package com.polich.kneecap



class PlantMaster {
    var isPlanted = false
    var isCanHarvest = false
    private val positiveMap = mutableMapOf<Culture, List<Culture>>(
        Plants.cultures[0] to listOf(Plants.cultures[1], Plants.cultures[2]),
        Plants.cultures[1] to listOf(Plants.cultures[0], Plants.cultures[2]),
        Plants.cultures[2] to listOf(Plants.cultures[1], Plants.cultures[0]),
        Plants.cultures[3] to listOf(Plants.cultures[1], Plants.cultures[0]),
        Plants.cultures[4] to listOf(Plants.cultures[1], Plants.cultures[0])
    )

    fun howIsGoodChoice(prev : Culture, next : Culture) : Int{
        val isGoodNext = positiveMap[prev]?.contains(next) ?: false
        return if (isGoodNext)
            1
        else
            0
    }
}

enum class Rate{
    RIGHT,
    WRONG
}
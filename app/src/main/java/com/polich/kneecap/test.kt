package com.polich.kneecap

import com.polich.kneecap.data.*

fun main(){
    val localEasyLevel = LevelDif.easyLevelEvent
    val localEasyAnswer = LevelDif.easyAnswer
    val current_event = getRandomEvent()
    current_event.sufferer
    localEasyAnswer.first().first().opponent.first().cataclysmVictim
    get(current_event).forEach {
        println(it)
    }
    println(current_event)
    println(getCultures())
}

fun getAnswers(event: Event): MutableSet<MethodsStruggle>? {
    val localEasyAnswer = LevelDif.easyAnswer
    localEasyAnswer.forEach {
        it.forEach { it1 ->

            it1.opponent.forEach { it2 ->
                if (it2.cataclysmVictim == event.sufferer)
                    return AllAnswerPositiveMap.answerPositiveMap[it2]?.toMutableSet()
            }
        }
    }
    return null
}

fun getRandomEvent() = climateEventForLevel.climateEvent[2]

fun getCultures(): MutableList<MethodsStruggle>? {
    BedClimate.bedClimateList.forEach {
        if (it.cataclysmName == getRandomEvent().eventName){
            return AllAnswerPositiveMap.answerPositiveMap[it]
        }
    }
    return null
}

fun getPositionEasy(event: Event): Int {
    var position = -1
    LevelDif.easyLevelEvent.forEachIndexed { index, it ->
        if (it == event)
            position = index
    }
    return position
}

fun get(event: Event): MutableSet<MethodsStruggle> {

    val position = getPositionEasy(event)
    return LevelDif.easyAnswer.toMutableList()[position]
}
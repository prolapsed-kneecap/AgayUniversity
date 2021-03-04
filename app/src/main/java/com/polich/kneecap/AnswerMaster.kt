package com.polich.kneecap

import android.util.Log
import com.polich.kneecap.data.*
import com.polich.kneecap.data.AAAllBed.aaalBed
import com.polich.kneecap.data.LevelDif.levelSection
import com.polich.kneecap.data.MethodsAll.alllMethods
import com.polich.kneecap.data.naturalEventForLevel.naturalEvent

fun main(){

    val event = naturalEvent[0]

    val all_cultures : MutableList<Culture> = Plants.cultures //все культуры

    val name_event = event.eventName
    val event_sufferer : MutableList<Culture> = event.sufferer //массив для жертв конкретного события

    //AnswerMaster(naturalEvent[0])
    println(searchMethod(event_sufferer, name_event))
}

fun searchMethod(event_sufferer : MutableList<Culture>, name_event: String): String {
    var search_name = ""
    for (i in 0 until aaalBed[0].size){
        val d = aaalBed[0][i].cataclysmName
        if (name_event == aaalBed[0][i].cataclysmName){
            search_name = aaalBed[0][i].cataclysmName
        }
    }
    for (i in 0 until aaalBed[1].size){
        val d = aaalBed[1][i].cataclysmName
        if (name_event == aaalBed[1][i].cataclysmName){
            search_name = aaalBed[1][i].cataclysmName
        }
    }
    for (i in 0 until aaalBed[2].size){
        val d = aaalBed[2][i].cataclysmName
        if (name_event == aaalBed[2][i].cataclysmName){
            search_name = aaalBed[2][i].cataclysmName
        }
    }

    /*for (i in 0 until aaalBed[0].size){
            val d = aaalBed[0][i].cataclysmName
            if (name_event == aaalBed[0][i].cataclysmName){
                search_name = aaalBed[0][i].cataclysmName
            }
        }*/
    return search_name
}
class AnswerMaster(event: Event) {
    val all_cultures : MutableList<Culture> = Plants.cultures //все культуры

    val name_event = event.eventName
    val event_sufferer : MutableList<Culture> = event.sufferer //массив для жертв конкретного события
}
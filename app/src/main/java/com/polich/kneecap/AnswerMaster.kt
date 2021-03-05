package com.polich.kneecap

import com.polich.kneecap.data.*
import com.polich.kneecap.data.AAAllBed.allBed
import com.polich.kneecap.data.BedBugs.bedBugsList
import com.polich.kneecap.data.BedClimate.bedClimateList
import com.polich.kneecap.data.BedNatural.bedNaturalList
import com.polich.kneecap.data.MethodsAll.allMethods

/*
fun main(){

    val event = bugsEvent[1]

    val all_cultures : MutableList<Culture> = Plants.cultures //все культуры

    val name_event = event.eventName
    val event_sufferer : MutableList<Culture> = event.sufferer //массив для жертв конкретного события

    //AnswerMaster(naturalEvent[0])
    for (item in 0..all_cultures.size-1){
        for (i in 0..event_sufferer.size-1){
            if (event_sufferer[i] == all_cultures[item]){
                println(event_sufferer[i].name)
                for (j in 0..bugsMethods.size-1){
                    for (k in 0..allMethods[0][1].opponent.size-1){
                        for (l in 0 until allMethods[0][1].opponent[k].cataclysmVictim.size){
                            val d = allMethods[0][1].opponent[k].cataclysmVictim[l].name
                            val m = event_sufferer[i].name
                            if ((allMethods[0][1].opponent[k].cataclysmVictim[l].toString() == event_sufferer[i].name)||
                                (allMethods[0][1].opponent[k].cataclysmVictim[l].toString() == event_sufferer[i].name)){
                                println(allMethods[0][j].methodName)
                            }
                        }
                        for (l in 0 until allMethods[1][1].opponent[k].cataclysmVictim.size){
                            val d = allMethods[1][1].opponent[k].cataclysmVictim[l].name
                            val m = event_sufferer[i].name
                            if ((allMethods[1][1].opponent[k].cataclysmVictim[l].toString() == event_sufferer[i].name)||
                                (allMethods[1][1].opponent[k].cataclysmVictim[l].toString() == event_sufferer[i].name)){
                                println(allMethods[1][j].methodName)
                            }
                        }
                    }
                }
            }
        }
    }
    println(searchMethod(event_sufferer, name_event))
}
*/

fun searchMethod(event_sufferer : MutableList<Culture>, name_event: String): String {
    var search_name = ""
    var positionInList = 0

    while (search_name == ""){

        for (i in 0 until allBed[0].size){
            if (name_event == allBed[0][i].cataclysmName){
                search_name = allBed[0][i].cataclysmName
                positionInList = i
            }
        }
        for (i in 0 until allBed[1].size){
            if (name_event == allBed[1][i].cataclysmName){
                search_name = allBed[1][i].cataclysmName
                positionInList = i
            }
        }
        for (i in 0 until allBed[2].size){
            if (name_event == allBed[2][i].cataclysmName){
                search_name = allBed[2][i].cataclysmName
                positionInList = i
            }
        }
    }
    return search_name
}
class AnswerMaster(event: Event)
object AllAnswerPositiveMap{
    val answerPositiveMap  = mutableMapOf(
        bedBugsList[3] to mutableListOf(allMethods[13]),
        bedBugsList[4] to mutableListOf(allMethods[4], allMethods[6], allMethods[12]),
        bedBugsList[5] to mutableListOf(allMethods[8], allMethods[12]),
        bedBugsList[6] to mutableListOf(allMethods[7], allMethods[11]),
        bedBugsList[7] to mutableListOf(allMethods[15], allMethods[14], allMethods[0], allMethods[4], allMethods[11]),

        bedClimateList[0] to mutableListOf(allMethods[20]),
        bedClimateList[1] to mutableListOf(),
        bedClimateList[2] to mutableListOf(),

        bedNaturalList [0] to mutableListOf(allMethods[18]),
        bedNaturalList[1] to mutableListOf(allMethods[16]),
        bedNaturalList[2] to mutableListOf(allMethods[17], allMethods[14]),
    )
}

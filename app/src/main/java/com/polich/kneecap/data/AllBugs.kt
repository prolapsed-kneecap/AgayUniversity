package com.polich.kneecap.data

import com.polich.kneecap.data.Plants.cultures

open class AllBugs(
     val bugsName : String,
     val bugsVictim : MutableList<Culture>
 )

object BedBugs{
    val bedBugsList = mutableListOf<AllBugs>(
        AllBugs("Пшеничная нематода", mutableListOf(cultures[0], cultures[2])),
        AllBugs("Блошка", mutableListOf(cultures[8])),
        AllBugs("Злаковая тля", mutableListOf(cultures[0], cultures[1], cultures[2], cultures[9], cultures[10])),
    )
}

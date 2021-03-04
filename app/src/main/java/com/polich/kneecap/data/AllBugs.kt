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
        AllBugs("Саранча", mutableListOf(cultures[0], cultures[1], cultures[2],cultures[3]
            ,cultures[4], cultures[5], cultures[6], cultures[8] ,cultures[9], cultures[10])),
        AllBugs("Совка", mutableListOf(cultures[6], cultures[7], cultures[8])),
        AllBugs("Хлебный жук", mutableListOf(cultures[0], cultures[1], cultures[2], cultures[10])),
        AllBugs("Шведская мушка", mutableListOf(cultures[0], cultures[1], cultures[2], cultures[8], cultures[9], cultures[10])),
        AllBugs("Жук-щелкун", mutableListOf(cultures[7]))
    )
}

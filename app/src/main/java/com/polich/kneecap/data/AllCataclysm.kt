package com.polich.kneecap.data

import com.polich.kneecap.data.BedBugs.bedBugsList
import com.polich.kneecap.data.BedClimate.bedClimateList
import com.polich.kneecap.data.BedNatural.bedNaturalList
import com.polich.kneecap.data.Plants.cultures

open class AllCataclysm(
    val cataclysmName : String,
    val cataclysmVictim : MutableList<Culture> //пострадавшее от катаклизма растения
 )

object AAAllBed{
    val allBed = mutableListOf<MutableList<AllCataclysm>>(bedNaturalList, bedBugsList, bedClimateList, )
}

object BedBugs{
    val bedBugsList = mutableListOf<AllCataclysm>(
        AllCataclysm("Пшеничная нематода", mutableListOf(cultures[0], cultures[2])),
        AllCataclysm("Блошка", mutableListOf(cultures[8])),
        AllCataclysm("Злаковая тля", mutableListOf(cultures[0], cultures[1], cultures[2], cultures[9], cultures[10])),
        AllCataclysm("Саранча", mutableListOf(cultures[0], cultures[1], cultures[2],cultures[3],cultures[4], cultures[5], cultures[6], cultures[8] ,cultures[9], cultures[10])),
        AllCataclysm("Совка", mutableListOf(cultures[6], cultures[7], cultures[8])),
        AllCataclysm("Хлебный жук", mutableListOf(cultures[0], cultures[1], cultures[2], cultures[10])),
        AllCataclysm("Шведская мушка", mutableListOf(cultures[0], cultures[1], cultures[2], cultures[8], cultures[9], cultures[10])),
        AllCataclysm("Жук-щелкун", mutableListOf(cultures[7]))
    )
}

object BedClimate{
    val bedClimateList = mutableListOf(
        AllCataclysm("Засуха", mutableListOf(cultures[0], cultures[1], cultures[2], cultures[10])),
        AllCataclysm("Град", mutableListOf(cultures[0], cultures[1], cultures[2], cultures[3], cultures[4], cultures[5], cultures[6], cultures[8], cultures[10])),
        AllCataclysm("Похолодание", mutableListOf(cultures[5], cultures[7])),
    )
}

object BedNatural{
    val bedNaturalList = mutableListOf(
        AllCataclysm("Смерч", mutableListOf(cultures[0], cultures[1], cultures[2],cultures[3],cultures[4], cultures[5], cultures[6], cultures[7], cultures[8] ,cultures[9], cultures[10])),
        AllCataclysm("Ливни и грозы", mutableListOf(cultures[7])),
        AllCataclysm("Пыльная буря", mutableListOf(cultures[5], cultures[7])),
    )
}



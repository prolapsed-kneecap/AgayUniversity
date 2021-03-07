package com.polich.kneecap

import com.polich.kneecap.data.BedBugs.bedBugsList
import com.polich.kneecap.data.BedClimate.bedClimateList
import com.polich.kneecap.data.BedNatural.bedNaturalList
import com.polich.kneecap.data.MethodsAll.allMethods

object AllAnswerPositiveMap{
    val answerPositiveMap  = hashMapOf(
        bedBugsList[3] to allMethods[13],
        bedBugsList[4] to allMethods[4], //allMethods[6], allMethods[12]),
        bedBugsList[5] to allMethods[8], //allMethods[12]),
        bedBugsList[6] to allMethods[11], //allMethods[7],
        bedBugsList[7] to allMethods[0], //allMethods[15], allMethods[14],  allMethods[4], allMethods[11],

        bedNaturalList[0] to allMethods[20],
        bedNaturalList[1] to  allMethods[20],
        bedNaturalList[2] to  allMethods[20],

        bedClimateList [0] to  allMethods[18],
        bedClimateList[1] to allMethods[16],
        bedClimateList[2] to allMethods[17], //allMethods[14]),
    )
}

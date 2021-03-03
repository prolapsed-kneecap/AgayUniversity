package com.polich.kneecap.data

import com.polich.kneecap.data.BedBugs.bedBugsList

open class MethodsStruggle(val methodName: String, val opponent: MutableList<AllBugs>)

object AgrotechnicalMethodsStruggle { //Агротехнические меры борьбы
    val agrotechnicalMethods : MutableList<MethodsStruggle> = mutableListOf(
        MethodsStruggle("Соблюдение севооборота", mutableListOf(bedBugsList[0], )),
        MethodsStruggle("Оптимальные сроки посева зерновых культур", mutableListOf(bedBugsList[1])),
        MethodsStruggle("Борьба с сорной растительностью", mutableListOf(bedBugsList[1], bedBugsList[2])),
        MethodsStruggle("Лущение стерни", mutableListOf(bedBugsList[2])),
        MethodsStruggle("Зяблевая вспашка", mutableListOf(bedBugsList[2])),
        MethodsStruggle("Посев озимых в оптимальные сроки", mutableListOf(bedBugsList[2])),
    )
}

object MechanicalMethodsStruggle { //Препараты для борьбы
    val mechanicalMethods : MutableList<MethodsStruggle> = mutableListOf(
        MethodsStruggle("Механическая чистка посевного материала", mutableListOf(bedBugsList[0])),
        MethodsStruggle("Обработка семян горячей водой", mutableListOf(bedBugsList[0])),
    )
}

object PreparationMethodsStruggle { //Препараты для борьбы
    val preparationMethods : MutableList<MethodsStruggle> = mutableListOf()
}

object BiologicalMethodsStruggle { //Биологический метод борьбы
    val biologicalMethods : MutableList<MethodsStruggle> = mutableListOf()
}

object ChemicalMethodsStruggle { //Химические методы борьбы
    val chemicalMethods : MutableList<MethodsStruggle> = mutableListOf(
        MethodsStruggle("Предпосевная обработка семян химическими протравителями",
            mutableListOf(bedBugsList[1])),
        MethodsStruggle("Опрыскивание растений пиретроидами, неоникотиноидамии другими инсектицидами",
            mutableListOf(bedBugsList[1], bedBugsList[2]))
    )
}


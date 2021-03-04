package com.polich.kneecap.data

import com.polich.kneecap.data.BedBugs.bedBugsList

open class MethodsStruggleBugs(val methodName: String, val opponent: MutableList<AllBugs>)

object AgrotechnicalMethodsStruggle { //Агротехнические меры борьбы
    val agrotechnicalMethods : MutableList<MethodsStruggleBugs> = mutableListOf(
        MethodsStruggleBugs("Соблюдение севооборота", mutableListOf(bedBugsList[0], bedBugsList[7])),
        MethodsStruggleBugs("Оптимальные сроки посева зерновых культур", mutableListOf(bedBugsList[1], bedBugsList[7])),
        MethodsStruggleBugs("Борьба с сорной растительностью", mutableListOf(bedBugsList[1],
            bedBugsList[2], bedBugsList[5], bedBugsList[7])),
        MethodsStruggleBugs("Лущение стерни", mutableListOf(bedBugsList[2], bedBugsList[6], bedBugsList[7])),
        MethodsStruggleBugs("Зяблевая вспашка", mutableListOf(bedBugsList[2], bedBugsList[4], bedBugsList[6], bedBugsList[7])),
        MethodsStruggleBugs("Посев озимых в оптимальные сроки", mutableListOf(bedBugsList[2])),
        MethodsStruggleBugs("Своевременная уборка урожая", mutableListOf(bedBugsList[4])),
        MethodsStruggleBugs("Подкормка озимых посевов", mutableListOf(bedBugsList[6])),
        MethodsStruggleBugs("Культивация зяби", mutableListOf(bedBugsList[5])),
        MethodsStruggleBugs("Механическая чистка посевного материала", mutableListOf(bedBugsList[0])),
        MethodsStruggleBugs("Обработка семян горячей водой", mutableListOf(bedBugsList[0]))
    )
}

object ChemicalMethodsStruggle { //Химические методы борьбы
    val chemicalMethods : MutableList<MethodsStruggleBugs> = mutableListOf(
        MethodsStruggleBugs("Предпосевная обработка семян химическими протравителями",
            mutableListOf(bedBugsList[1], bedBugsList[6], bedBugsList[7])),
        MethodsStruggleBugs("Опрыскивание растений пиретроидами, неоникотиноидамии другими инсектицидами",
            mutableListOf(bedBugsList[1], bedBugsList[2], bedBugsList[4], bedBugsList[5])),
        MethodsStruggleBugs("Опрыскивание резерваций вредителя биологическими инсектицидами",
            mutableListOf(bedBugsList[3])),
        MethodsStruggleBugs("Внесение минеральных и органических удобрений", mutableListOf(bedBugsList[7])),
        MethodsStruggleBugs("Применение паразитических и хищных насекомых", mutableListOf(bedBugsList[7]))
    )
}


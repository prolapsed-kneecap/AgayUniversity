//package com.polich.kneecap.data
//
//import com.polich.kneecap.data.BedBugs.bedBugsList
//import com.polich.kneecap.data.BedClimate.bedClimateList
//import com.polich.kneecap.data.BedNatural.bedNaturalList
//
//open class MethodsStruggle(val methodName: String, var opponent: MutableList<AllCataclysm>)
//
//object MethodsAll { //Агротехнические и химические меры борьбы
//    val allMethods : MutableList<MethodsStruggle> = mutableListOf(
//        MethodsStruggle("Соблюдение севооборота", mutableListOf(bedBugsList[0], bedBugsList[7])),
//        MethodsStruggle("Оптимальные сроки посева зерновых культур", mutableListOf(bedBugsList[1], bedBugsList[7])),
//        MethodsStruggle("Борьба с сорной растительностью", mutableListOf(bedBugsList[1], bedBugsList[2], bedBugsList[5], bedBugsList[7], bedNaturalList[1])),
//        MethodsStruggle("Лущение стерни", mutableListOf(bedBugsList[2], bedBugsList[6], bedBugsList[7])), //3
//        MethodsStruggle("Зяблевая вспашка", mutableListOf(bedBugsList[2], bedBugsList[4], bedBugsList[6], bedBugsList[7])),
//        MethodsStruggle("Посев озимых в оптимальные сроки", mutableListOf(bedBugsList[2])),
//        MethodsStruggle("Своевременная уборка урожая", mutableListOf(bedBugsList[4])), //6
//        MethodsStruggle("Подкормка озимых посевов", mutableListOf(bedBugsList[6])),
//        MethodsStruggle("Культивация зяби", mutableListOf(bedBugsList[5])),
//        MethodsStruggle("Механическая чистка посевного материала", mutableListOf(bedBugsList[0])), //9
//        MethodsStruggle("Обработка семян горячей водой", mutableListOf(bedBugsList[0])),
//        MethodsStruggle("Предпосевная обработка семян химическими протравителями", mutableListOf(bedBugsList[1], bedBugsList[6], bedBugsList[7])),
//        MethodsStruggle("Опрыскивание растений пиретроидами, неоникотиноидамии другими инсектицидами", mutableListOf(bedBugsList[1], bedBugsList[2], bedBugsList[4], bedBugsList[5])),
//        MethodsStruggle("Опрыскивание резерваций вредителя биологическими инсектицидами", mutableListOf(bedBugsList[3])), //13
//        MethodsStruggle("Внесение минеральных и органических удобрений", mutableListOf(bedBugsList[7], bedClimateList[2], bedNaturalList[2])),
//        MethodsStruggle("Применение паразитических и хищных насекомых", mutableListOf(bedBugsList[7])),
//        MethodsStruggle("Частое рыхление", mutableListOf(bedNaturalList[1])), //16
//        MethodsStruggle("Окучивание", mutableListOf(bedClimateList[2], bedNaturalList[2])),
//        MethodsStruggle("Регулируемое и лиманное орошение", mutableListOf(bedClimateList[0])),
//        MethodsStruggle("Комплекс аминокислот для преодаления стресса", mutableListOf(bedClimateList[1])),
//        MethodsStruggle("Нет спасаения", mutableListOf(bedNaturalList[0])), //20
//        )
//}
//

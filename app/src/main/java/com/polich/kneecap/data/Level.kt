package com.polich.kneecap.data

//import com.polich.kneecap.data.BedBugs.bedBugsList
//import com.polich.kneecap.data.BedClimate.bedClimateList
//import com.polich.kneecap.data.BedNatural.bedNaturalList
//import com.polich.kneecap.data.MethodsAll.allMethods
//import com.polich.kneecap.data.bugsEventForLevel.bugsEvent
//import com.polich.kneecap.data.climateEventForLevel.climateEvent
//import com.polich.kneecap.data.naturalEventForLevel.naturalEvent

object LevelDif {
//     val easyLevelEvent: MutableList<Event> = mutableListOf(naturalEvent[0], climateEvent[2], bugsEvent[0])
//     val mediumLevelEvent: MutableList<Event> = mutableListOf(bugsEvent[2], naturalEvent[1], climateEvent[1], bugsEvent[4])
//     val hardLevelEvent: MutableList<Event> = mutableListOf(bugsEvent[0], bugsEvent[1], climateEvent[0], bugsEvent[3], naturalEvent[2])

//    val goodAnswerEasy: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[18], allMethods[17], allMethods[13])
//    val goodAnswerMedium: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[8], allMethods[20], allMethods[16], allMethods[0])
//    val goodAnswerHard: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[13], allMethods[4], allMethods[18], allMethods[11], allMethods[20])
//
//    val badAnswer: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[1], allMethods[2], allMethods[3], allMethods[5], allMethods[3], allMethods[9], allMethods[12], allMethods[15])

    val levelSection: List<Level> = listOf(
        Level("1", 3, 4),
        Level("2", 4, 6),
        Level("3", 6, 8 ),
        )
}

class Level(val name: String, val amountOfEvents: Int,
            val years: Int, )

//object naturalEventForLevel {
//    val naturalEvent = mutableListOf<NaturalDisasters>(
//        NaturalDisasters(
//            bedNaturalList[0].cataclysmName, 1,
//            "На ваши поля надвигается смерч. " +
//                    "Вздымая тучи земли и пыли, смерчи могут пронести " +
//                    "песчанную смесь несколько сотен метров и потерять", bedNaturalList[0].cataclysmVictim
//        ),
//        NaturalDisasters(
//            bedNaturalList[1].cataclysmName, 1,
//            "Над степью нависли тучи. Ожидаются продолжительные дожди. " +
//                    "Затяжные дожди могут привести к частичной или полной потере урожаяю. " +
//                    "Почва становится плотной и воздух не проникает в почву. Света и тепла становится меньше. " +
//                    "Дожди способствуют увеличению слизней и улиток.", bedNaturalList[1].cataclysmVictim
//        ),
//        NaturalDisasters(
//            bedNaturalList[2].cataclysmName, 2,
//            "Разрушение почвенного покрова негативно влияет на урожйность.", bedNaturalList[2].cataclysmVictim
//        )
//    )
//}
//object climateEventForLevel {
//    val climateEvent = mutableListOf<ClimateDisasters>(
//        ClimateDisasters(
//            bedClimateList[0].cataclysmName, 3,
//            " Палящее солнце иссушило сочные, высотой по колено золотистые травы до" +
//                    " самой сердцевины, каждая травинка стала хрусткой и ломкой. Это " +
//                    "агрометеорологическое явление, вызывающее резкое несоответствие " +
//                    "между потребностью растений во влаге и ее поступлением из почвы в результате" +
//                    " недостаточного количества осадков и повышенной испаряемости, что " +
//                    "нарушает нормальное водоснабжение растений.", bedClimateList[0].cataclysmVictim
//        ),
//        ClimateDisasters(
//            bedClimateList[1].cataclysmName, 2,
//            "Получая повреждения растения начинают испытывать стресс. Стресс " +
//                    "заставляет растение тратить энергию на выживание в экстремальных " +
//                    "условиях в ущерб урожаю и его качеству. Сократить потери может только " +
//                    "своевременная помощь растениям в преодолении стресса.", bedClimateList[1].cataclysmVictim
//        ),
//        ClimateDisasters(
//            bedClimateList[2].cataclysmName, 1,
//            "Заморозки наносят существенный материальный ущерб сельскому хозяйству. " +
//                    "Особенно чувствительны к заморозкам теплолюбивые культуры.", bedClimateList[2].cataclysmVictim
//        )
//    )
//}
//object bugsEventForLevel {
//    val bugsEvent = mutableListOf<Bugsss>(
//        Bugsss(
//            bedBugsList[3].cataclysmName, 3,
//            "Ваше хойзяйстов под большой угрозой. Нашестиве саранчи! Всеядный вредитель, с наибольшей активностью питания в ранние утренние и " +
//                    "вечерние часы, когда отсутствует пик жары. Одна особь съедает до 500 г растений" +
//                    " с разной плотностью вегетативных и генеративных органов (листьев, цветов, " +
//                    "молодых веток, стеблей, плодов).", bedBugsList[3].cataclysmVictim
//        ),
//        Bugsss(
//            bedBugsList[4].cataclysmName, 3,
//            "В старину Cовку за ее вредоносность называли северной саранчой и озимым червем. " +
//                    "Личинки выедают прорастающие семена пшеницы, отчего происходит прореживание всходов, " +
//                    "и образуются оголенные участки поля.", bedBugsList[4].cataclysmVictim
//
//        ),
//        Bugsss(
//            bedBugsList[5].cataclysmName,
//            3,
//            "Цепкими лапками эти хлебные жуки перебирают колоски и перелетают на новые " +
//                    "растения в поисках пищи. В просторечье этого жука называют «хлебным кузькой». " +
//                    "Но, не смотря на такое милое название, этот жук является одним из самых злостных" +
//                    " массовых вредителей посевов. Эти вредители наносят колоссальный урон сельскому хозяйству.",
//            bedBugsList[5].cataclysmVictim
//        ),
//        Bugsss(
//            bedBugsList[6].cataclysmName, 3,
//            "Самый большой вред сельскохозяйственным культурам причиняют личинки шведских мух, " +
//                    "которые выедают злаки и близлежащие ткани. В результате у злаков отмирают центральные " +
//                    "листья, что приводит к замедлению роста растения или к полной его гибели. Личинки поедают " +
//                    "зерна, не давая им созреть, что приводит к снижению урожая.",
//            bedBugsList[6].cataclysmVictim
//        ),
//        Bugsss(
//            bedBugsList[7].cataclysmName, 3,
//            "Ваши растения под большой угрозой. " +
//                    "Жук-щелкун причиняет огромный вред сельскохозяйственным угодьям. " +
//                    "В частности, не сам жук, а его потомство личинок. " +
//                    "Проволочники находятся в верхнем слое почвы, " +
//                    "где поедают сначала семена растений, а затем пробирается внутрь " +
//                    "самой корневой системы. Поврежденные растения становятся жертвой " +
//                    "сапротрофов, в результате чего они быстро загнивают. Для защиты от " +
//                    "этих вредителей следует принимать предупредительные меры, поскольку " +
//                    "если он уже заведется, то избавиться от него будет крайне проблематично.",
//            bedBugsList[7].cataclysmVictim
//        )
//    )
//}
package com.polich.kneecap.data

import com.polich.kneecap.data.AnswerAllLevel.easyLevelAnswers1
import com.polich.kneecap.data.AnswerAllLevel.easyLevelAnswers2
import com.polich.kneecap.data.AnswerAllLevel.easyLevelAnswers3
import com.polich.kneecap.data.AnswerAllLevel.hardLevelAnswers1
import com.polich.kneecap.data.AnswerAllLevel.hardLevelAnswers2
import com.polich.kneecap.data.AnswerAllLevel.hardLevelAnswers3
import com.polich.kneecap.data.AnswerAllLevel.hardLevelAnswers4
import com.polich.kneecap.data.AnswerAllLevel.hardLevelAnswers5
import com.polich.kneecap.data.AnswerAllLevel.mediumLevelAnswers1
import com.polich.kneecap.data.AnswerAllLevel.mediumLevelAnswers2
import com.polich.kneecap.data.AnswerAllLevel.mediumLevelAnswers3
import com.polich.kneecap.data.AnswerAllLevel.mediumLevelAnswers4
import com.polich.kneecap.data.BedBugs.bedBugsList
import com.polich.kneecap.data.BedClimate.bedClimateList
import com.polich.kneecap.data.BedNatural.bedNaturalList
import com.polich.kneecap.data.MethodsAll.allMethods
import com.polich.kneecap.data.bugsEventForLevel.bugsEvent
import com.polich.kneecap.data.climateEventForLevel.climateEvent
import com.polich.kneecap.data.naturalEventForLevel.naturalEvent

object LevelDif {
     val easyLevelEvent: MutableList<Event> = mutableListOf(naturalEvent[0], climateEvent[2], bugsEvent[0])
     val mediumLevelEvent: MutableList<Event> = mutableListOf(bugsEvent[2], naturalEvent[1], climateEvent[1], bugsEvent[4])
     val hardLevelEvent: MutableList<Event> = mutableListOf(bugsEvent[0], bugsEvent[1], climateEvent[0], bugsEvent[3], naturalEvent[2])

    val easyAnswer = mutableSetOf<MutableSet<MethodsStruggle>>(easyLevelAnswers1, easyLevelAnswers2, easyLevelAnswers3)
    val mediumAnswer = mutableSetOf<MutableSet<MethodsStruggle>>(mediumLevelAnswers1, mediumLevelAnswers2, mediumLevelAnswers3, mediumLevelAnswers4)
    val hardAnswer = mutableSetOf<MutableSet<MethodsStruggle>>(hardLevelAnswers1, hardLevelAnswers2, hardLevelAnswers3, hardLevelAnswers4, hardLevelAnswers5)

    val levelSection: List<Level> = listOf(
        Level("1", 3, 4, easyLevelEvent, easyAnswer),
        Level("2", 4, 6, mediumLevelEvent, mediumAnswer),
        Level("3", 6, 8, hardLevelEvent, hardAnswer),
        )
}

object AnswerAllLevel{
    val easyLevelAnswers1: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[11], allMethods[20], allMethods[6], allMethods[8])
    val easyLevelAnswers2: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[2], allMethods[12], allMethods[17], allMethods[10])
    val easyLevelAnswers3: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[3], allMethods[16], allMethods[0], allMethods[13])

    val mediumLevelAnswers1: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[8], allMethods[19], allMethods[10], allMethods[3],)
    val mediumLevelAnswers2: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[14], allMethods[7], allMethods[16], allMethods[17],)
    val mediumLevelAnswers3: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[19], allMethods[11], allMethods[14], allMethods[7])
    val mediumLevelAnswers4: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[6], allMethods[15], allMethods[1], allMethods[4])

    val hardLevelAnswers1: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[3], allMethods[17], allMethods[0], allMethods[8])
    val hardLevelAnswers2: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[1], allMethods[6], allMethods[13], allMethods[15])
    val hardLevelAnswers3: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[10], allMethods[8], allMethods[18], allMethods[19])
    val hardLevelAnswers4: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[5], allMethods[12], allMethods[7], allMethods[20])
    val hardLevelAnswers5: MutableSet<MethodsStruggle> = mutableSetOf(allMethods[17], allMethods[6], allMethods[2], allMethods[9])
}

class Level(val name: String, val amountOfEvents: Int,
            val years: Int, var events: MutableList<Event>, var answers:  MutableSet<MutableSet<MethodsStruggle>>)

object naturalEventForLevel {
    val naturalEvent = mutableListOf<NaturalDisasters>(
        NaturalDisasters(
            bedNaturalList[0].cataclysmName, 1,
            "На ваши поля надвигается смерч. " +
                    "Вздымая тучи земли и пыли, смерчи могут пронести " +
                    "песчанную смесь несколько сотен метров и потерять", bedNaturalList[0].cataclysmVictim
        ),
        NaturalDisasters(
            bedNaturalList[1].cataclysmName, 1,
            "Над степью нависли тучи. Ожидаются продолжительные дожди. " +
                    "Затяжные дожди могут привести к частичной или полной потере урожаяю. " +
                    "Почва становится плотной и воздух не проникает в почву. Света и тепла становится меньше. " +
                    "Дожди способствуют увеличению слизней и улиток.", bedNaturalList[1].cataclysmVictim
        ),
        NaturalDisasters(
            bedNaturalList[2].cataclysmName, 2,
            "Разрушение почвенного покрова негативно влияет на урожйность.", bedNaturalList[2].cataclysmVictim
        )
    )
}
object climateEventForLevel {
    val climateEvent = mutableListOf<ClimateDisasters>(
        ClimateDisasters(
            bedClimateList[0].cataclysmName, 3,
            " Палящее солнце иссушило сочные, высотой по колено золотистые травы до" +
                    " самой сердцевины, каждая травинка стала хрусткой и ломкой. Это " +
                    "агрометеорологическое явление, вызывающее резкое несоответствие " +
                    "между потребностью растений во влаге и ее поступлением из почвы в результате" +
                    " недостаточного количества осадков и повышенной испаряемости, что " +
                    "нарушает нормальное водоснабжение растений.", bedClimateList[0].cataclysmVictim
        ),
        ClimateDisasters(
            bedClimateList[1].cataclysmName, 2,
            "Получая повреждения растения начинают испытывать стресс. Стресс " +
                    "заставляет растение тратить энергию на выживание в экстремальных " +
                    "условиях в ущерб урожаю и его качеству. Сократить потери может только " +
                    "своевременная помощь растениям в преодолении стресса.", bedClimateList[1].cataclysmVictim
        ),
        ClimateDisasters(
            bedClimateList[2].cataclysmName, 1,
            "Заморозки наносят существенный материальный ущерб сельскому хозяйству. " +
                    "Особенно чувствительны к заморозкам теплолюбивые культуры.", bedClimateList[2].cataclysmVictim
        )
    )
}
object bugsEventForLevel {
    val bugsEvent = mutableListOf<Bugsss>(
        Bugsss(
            bedBugsList[3].cataclysmName, 3,
            "Ваше хойзяйстов под большой угрозой. Нашестиве саранчи! Всеядный вредитель, с наибольшей активностью питания в ранние утренние и " +
                    "вечерние часы, когда отсутствует пик жары. Одна особь съедает до 500 г растений" +
                    " с разной плотностью вегетативных и генеративных органов (листьев, цветов, " +
                    "молодых веток, стеблей, плодов).", bedBugsList[3].cataclysmVictim
        ),
        Bugsss(
            bedBugsList[4].cataclysmName, 3,
            "В старину Cовку за ее вредоносность называли северной саранчой и озимым червем. " +
                    "Личинки выедают прорастающие семена пшеницы, отчего происходит прореживание всходов, " +
                    "и образуются оголенные участки поля.", bedBugsList[4].cataclysmVictim

        ),
        Bugsss(
            bedBugsList[5].cataclysmName,
            3,
            "Цепкими лапками эти хлебные жуки перебирают колоски и перелетают на новые " +
                    "растения в поисках пищи. В просторечье этого жука называют «хлебным кузькой». " +
                    "Но, не смотря на такое милое название, этот жук является одним из самых злостных" +
                    " массовых вредителей посевов. Эти вредители наносят колоссальный урон сельскому хозяйству.",
            bedBugsList[5].cataclysmVictim
        ),
        Bugsss(
            bedBugsList[6].cataclysmName, 3,
            "Самый большой вред сельскохозяйственным культурам причиняют личинки шведских мух, " +
                    "которые выедают злаки и близлежащие ткани. В результате у злаков отмирают центральные " +
                    "листья, что приводит к замедлению роста растения или к полной его гибели. Личинки поедают " +
                    "зерна, не давая им созреть, что приводит к снижению урожая.",
            bedBugsList[6].cataclysmVictim
        ),
        Bugsss(
            bedBugsList[7].cataclysmName, 3,
            "Ваши растения под большой угрозой. " +
                    "Жук-щелкун причиняет огромный вред сельскохозяйственным угодьям. " +
                    "В частности, не сам жук, а его потомство личинок. " +
                    "Проволочники находятся в верхнем слое почвы, " +
                    "где поедают сначала семена растений, а затем пробирается внутрь " +
                    "самой корневой системы. Поврежденные растения становятся жертвой " +
                    "сапротрофов, в результате чего они быстро загнивают. Для защиты от " +
                    "этих вредителей следует принимать предупредительные меры, поскольку " +
                    "если он уже заведется, то избавиться от него будет крайне проблематично.",
            bedBugsList[7].cataclysmVictim
        )
    )
}
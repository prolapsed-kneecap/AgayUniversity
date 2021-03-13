package com.polich.kneecap.data

import com.polich.kneecap.Harvesters

object Plants {
    val plants = arrayOf("Рожь", "Овёс", "Пшеница", "Гречиха", "Просо","Подсолнечник","Горох","Картофель","Кукуруза","Ячмень")

    var isPlanted = false
    var isCanHarvest = false

    var counter = 0

    lateinit var rline: FloatArray
    lateinit var gline: FloatArray
    lateinit var bline: FloatArray
    lateinit var lline: FloatArray

    init {
        initFilter()
    }

    fun initFilter() {
        rline = floatArrayOf(0f, 0f, 0f, 0f)
        gline = floatArrayOf(0f, 0.8f, 0f, 0f)
        bline = floatArrayOf(0f, 0f, 0f, 0f)
        lline = floatArrayOf(0f, 0f, 0f, 0.9f)
    }

    val cultures: MutableList<Culture> = mutableListOf(
        Culture("Рожь", "Зерновые"),
        Culture("Овёс", "Зерновые"),
        Culture("Пшеница", "Зерновые"),
        Culture("Гречиха", "Зерновые"),
        Culture("Просо",  "Зерновые"),
        Culture("Подсолнечник",  "Зерновые"), //5
        Culture("Горох", "Зернобобовые"),
        Culture("Картофель",  "Коромовые корнеплоды"),
        Culture("Кукуруза", "Зерновые"),
        Culture("Овес", "Зерновые"),
        Culture("Ячмень", "Зерновые"), //10
    )
    fun cmDataInvalidate():FloatArray{
        val cmData: FloatArray = floatArrayOf(
            rline[0], rline[1], rline[2], rline[3], 0f,
            gline[0], gline[1], gline[2], gline[3], 0f,
            bline[0], bline[1], bline[2], bline[3], 0f,
            lline[0], lline[1], lline[2], lline[3], 0f
        )
        return cmData
    }
}

object History {
    var plantHistory: MutableList<Culture> = mutableListOf()
}

object Eventik{
    val solutions:Array<Harvesters> = arrayOf(
        Harvesters("Комбайн")
        )
    var instruments:MutableList<Harvesters> = mutableListOf(
        Harvesters("Плуг"),
        Harvesters("Борона"),
        Harvesters("Лущильник"),
        Harvesters("Комбайн"),
        Harvesters("Культиватор"),
        Harvesters("Катки"),
    )
}
object TemporaryObject /*Временно существующий объект*/{
    var amountOfHappendEvents = 0
    var playerScore = 0 // счёт игрока (пока будет выглядеть так)
    var damageMultiplier = 100// damageMultiplier:Int - число на которое будет умножаться важность (зависит от выбраной сложности), пока что хранится в объекте, нужен для функции damage
    var progressBarNeedsToBeFilled = false
}
object FilterObject{
    var aline = 0
    var rlineResult = 105
    var glineResult = 105
    var blineResult = 105
}
object PlayerResults{
    var scoreHistory = mutableListOf<Int>(
        0, 0, 0
    )
}

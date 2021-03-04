package com.polich.kneecap.data

import com.polich.kneecap.Harvesters

object Plants {
    val plants = arrayOf("Рожь", "Овёс", "Пшеница", "Гречиха", "Просо")

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
        var cmData: FloatArray = floatArrayOf(
            rline[0], rline[1], rline[2], rline[3], 0f,
            gline[0], gline[1], gline[2], gline[3], 0f,
            bline[0], bline[1], bline[2], bline[3], 0f,
            lline[0], lline[1], lline[2], lline[3], 0f
        )
        return cmData
    }
}


/*object CheckGood {
    private val positiveMap = mutableMapOf<Culture, List<Culture>>(
        data.cultures[0] to listOf(cultures[1], cultures[2]),
        data.cultures[1] to listOf(cultures[0], cultures[2]),
        data.cultures[2] to listOf(cultures[1], cultures[0])
    )

    fun c(prev : Culture, next : Culture) : Rate{
        val isGoodNext = positiveMap[prev]?.contains(next) ?: false
        if (isGoodNext)
            return  Rate.GOOD
        else
            return  Rate.BAD
    }

}*/

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
    /*val event = Event("Сорняки!", solutions)*/
}
object TemporaryObject /*Временно существующий объект*/{
    var amountOfHappendEvents = 0
    var playerScore = 750 // счёт игрока (пока будет выглядеть так)
    var damageMultiplier = 0// damageMultiplier:Int - число на которое будет умножаться важность (зависит от выбраной сложности), пока что хранится в объекте, нужен для функции damage
    var progressBarNeedsToBeFilled = false
}

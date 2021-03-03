package com.polich.kneecap.data
import com.polich.kneecap.data.TemporaryObject.damageMultiplier

abstract class Event{
    abstract val eventName:String
    abstract val importance:Int
    abstract val description:String
    abstract fun Damage(playerScore:Int, importance: Int): Int
}
class NaturalDisasters(override val eventName: String, override val importance: Int, override val description: String):
    Event(){
    override fun Damage(playerScore:Int, importance: Int): Int {
        return playerScore-importance*damageMultiplier// damageMultiplier:Int - число на которое будет умножаться важность (зависит от выбраной сложности), пока что хранится в объекте
    }
}

class ClimateDisasters(override val eventName: String, override val importance: Int, override val description: String):
    Event(){
    override fun Damage(playerScore:Int, importance: Int): Int {
        return playerScore-importance*damageMultiplier
    }
}

class Bugsss(override val eventName: String, override val importance: Int, override val description: String):
    Event(){
    override fun Damage(playerScore:Int, importance: Int): Int {
        return playerScore-importance*damageMultiplier
    }
}

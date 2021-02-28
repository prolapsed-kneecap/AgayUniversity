package com.polich.kneecap

abstract class Event{
    abstract val eventName:String
    abstract val importance:Int
    abstract val description:String
    abstract fun damage(importance: Int): Int
}
class NaturalDisasters(override val eventName: String, override val importance: Int, override val description: String):Event(){
    override fun damage(importance: Int): Int {
        return 3
    }

}
class Bugs(override val eventName: String, override val importance: Int, override val description: String):Event(){
    override fun damage(importance: Int): Int {
        return 3
    }
}
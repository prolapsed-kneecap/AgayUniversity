//package com.polich.kneecap
//
//import com.polich.kneecap.data.Culture
//import com.polich.kneecap.data.Plants
//
//class Harvesters(val name:String,){}
//
//class InstrumentMaster(){
//    var instrumentCanBeUsed = true
//    private val map_instruments_positive = mutableMapOf<Culture, MutableList<Harvesters>>(
//        Plants.cultures[0] to mutableListOf(harvesters[2], harvesters[3]),
//        Plants.cultures[1] to mutableListOf(harvesters[2], harvesters[3]),
//        Plants.cultures[2] to mutableListOf(harvesters[2], harvesters[3]),
//        Plants.cultures[3] to mutableListOf(harvesters[2], harvesters[3]),
//        Plants.cultures[4] to mutableListOf(harvesters[2], harvesters[3]),
//        Plants.cultures[5] to mutableListOf(harvesters[2], harvesters[3]),
//        Plants.cultures[6] to mutableListOf(harvesters[2], harvesters[3]),
//    )
//    fun InstrumentUse(instrument: Harvesters, culture: Culture):String{
//        val Check = map_instruments_positive[culture]?.contains(instrument) ?: false
//        return if (Check)
//            "RIGHT"
//        else
//            "WRONG"
//    }
//}
//var harvesters:MutableList<Harvesters> = mutableListOf(
//    Harvesters("Плуг"),
//    Harvesters("Борона"),
//    Harvesters("Лущильник"),
//    Harvesters("Комбайн"),
//
//    Harvesters("Катки"),
//)
abstract class Instrument(var isUSed:Boolean, var name:String): RecycleItem

class Seeder(isUSed: Boolean, name:String):Instrument(isUSed, name){
    override var typeItem: TypeItem = TypeItem.SEEDER
}
class Combine(isUSed: Boolean, name:String):Instrument(isUSed, name) {
    override var typeItem: TypeItem = TypeItem.COMBINE
}


interface RecycleItem {
    val typeItem : TypeItem
}

enum class TypeItem(val id : Int) {
    SEEDER(0),
    COMBINE(1);


}

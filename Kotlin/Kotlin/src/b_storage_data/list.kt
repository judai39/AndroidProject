package b_storage_data

/**有序的存储数据的存储结构 List*/
class MyList {
    //List不可变列表(不可以修改)
    private val readOnlyList = listOf("三角形", "圆形", "椭圆形")
    //MutableList可变列表(可以修改)
    private val readOnlyMutableList= mutableListOf("三角形","圆形","椭圆形")

    fun print() {
        println(readOnlyList)
        println(readOnlyMutableList)
    }

    fun getFirst() :String{
        return readOnlyList.first()
    }

    fun getLast():String{
        return readOnlyList.last()
    }

    fun getListSize():Int{
        return readOnlyList.count()
    }
    fun isHaveElement(element:String):Boolean{
        return element in readOnlyList
    }
    fun mutableListAdd(element:String){
        readOnlyMutableList.add(element)
    }
    fun mutableListRemove(element:String):Boolean{
        return readOnlyMutableList.remove(element)
    }
}

fun main() {
    val myList = MyList()
    myList.print()
    println("第一个元素是"+myList.getFirst())
    println("最后一个元素是"+myList.getLast())
    println("ReadOnlyList的长度是"+myList.getListSize())
    println("五角星型是否在ReadOnlyList中"+myList.isHaveElement("五角星型"))
    myList.mutableListAdd("五角星形")
    myList.print()
    println("是否删除成功?"+myList.mutableListRemove("五角星形"))
}
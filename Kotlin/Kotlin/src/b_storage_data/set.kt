package b_storage_data

/**无序的存储数据结构 set*/
class MySet {

    private val readOnlySet=setOf("无序","的","数据")
    private val readOnlyMutableSet= mutableSetOf("无序","的","可变","数据")

    fun print(){
//        println(readOnlySet)
        println(readOnlyMutableSet)
    }

    fun getSize(){
        println(readOnlyMutableSet.count())
    }

    fun isHaveElement(){
        println("的" in readOnlyMutableSet)
    }

    fun addElement(){
        readOnlyMutableSet.add("添加")
    }

    fun removeElement(){
        println("是否删除完成?"+readOnlyMutableSet.remove("的"))
    }
}

fun main() {
    val mySet=MySet()
    mySet.print()
    mySet.addElement()
    mySet.removeElement()
    mySet.isHaveElement()
    mySet.getSize()
}
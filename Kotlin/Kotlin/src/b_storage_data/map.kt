package b_storage_data

class MyMap{
    private val readOnlyMap = mapOf("第一" to "这是第一个","第二" to "这是第二个","第三" to "这是第三个")
    private val readOnlyMutableMap = mutableMapOf("第一" to "这是第一个","第二" to "这是第二个","第三" to "这是第三个")
    fun print(str:String){
        println("The First Value Is ${readOnlyMutableMap[str]}")
    }

    fun addElement(){
        readOnlyMutableMap["add_element"]="添加的元素"
    }

    fun removeElement(){
        readOnlyMutableMap.remove("add_element")
    }

    fun isHave(){
        print("第一" in readOnlyMutableMap)
        print(readOnlyMutableMap.containsKey("第一"))
    }

    fun getSize():Int{
        return readOnlyMutableMap.count()
    }

    fun getValues():MutableCollection<String>{
        return readOnlyMutableMap.values
    }

    fun getKeys():MutableCollection<String>{
        return readOnlyMutableMap.keys
    }
}

fun main() {
    val myMap=MyMap()
    myMap.print("add_element")
    myMap.addElement()
    myMap.print("add_element")

    print(myMap.getKeys()+"--"+myMap.getValues())   //[第一, 第二, 第三, add_element, --, 这是第一个, 这是第二个, 这是第三个, 添加的元素]
}
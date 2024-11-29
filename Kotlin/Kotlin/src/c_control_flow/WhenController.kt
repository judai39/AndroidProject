package c_control_flow

class WhenController {
    fun test(){
        val checkStr="Hello"
        when(checkStr){
            "1" -> println("one")
            "Hello" -> println("hello")
            else -> println("other")
        }
    }
}

fun main() {
    val obj=WhenController()
    obj.test()
    //when控制流也拥有返回值
    val strState="Red"
    /**获取when的返回值必须要有else逻辑,因为"必须获得一个实例对象,不写else可能会空指针"*/
    val whenReturn=when{
       strState=="Green" -> "绿色"
       strState=="Red" -> "红色"
       strState=="Yellow" -> "黄色"
        else -> "other"
    }
    //也可以这样写
//    val whenReturn=when("Red"){
//        strState=="Green" -> "绿色"
//        strState=="Red" -> "红色"
//        strState=="Yellow" -> "黄色"
//        else -> "other"
//    }
    print(whenReturn)
}
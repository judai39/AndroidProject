package f_operator.lazy

import kotlin.reflect.KProperty

/**by是封装完成的一种委托设计思想*/

interface Printer{
    fun print(message:String)
}

class DefaultPrinter:Printer{
    override fun print(message: String) {
        print("this is default print fun")
    }
}

/**将CustomPrinter委托给构造器中实例化的printer*/
class CustomPrinter(private val printer:DefaultPrinter):Printer by printer{}

//fun main() {
//    val customPrinter=CustomPrinter(DefaultPrinter())
//}


/**自定义委托类(Example维护着一个委托类,该委托类中维护着setter和getter)*/
class CustomDelegate{
    private var value:String=""

    operator fun getValue(thisRef:Any?,property:KProperty<*>):String{
        println("Getting Value:$value")
        return value
    }

    operator fun setValue(thisRef:Any?,property: KProperty<*>,newValue: String){
        println("Setting Value:$newValue")
        value=newValue
    }
}

class Example{
    var customProperty:String by CustomDelegate()
}

fun main() {
    val example=Example()
    example.customProperty="hello,world"    //将会调用setValue()
    println(example.customProperty)         //将会调用getValue()
}


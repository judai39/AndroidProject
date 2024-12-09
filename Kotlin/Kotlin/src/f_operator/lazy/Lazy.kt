package f_operator.lazy

import kotlin.reflect.KProperty

class Lazy<T>(private val initializer:()->T) {
    private var value:T?=null
    private var isInitialized:Boolean=false

    /**必要*/
    operator fun getValue(thisRef:Any?,property:KProperty<*>):T{
            //第一次将index置为true,第二次才会进入
        if (!isInitialized){
            value=initializer()
            isInitialized=true
        }
        return value!!
    }
    /**必要*/
    operator fun setValue(thisRef: Any?,property: KProperty<*>,newValue:T){
        this.value=newValue
    }
}

fun <T> lazy(initializer: () -> T)=Lazy(initializer)
var myProperty:String by lazy{
    println("将会延迟加载")
    "hello"
}

fun main() {
    println(myProperty) //执行初始化逻辑,仅实例化这一次(index被设置为false了)
    println(myProperty) //返回实例化的值
}

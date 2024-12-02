package f_operator

/**is运算符检测类型兼容*/

class Is {
    private val str:String="字符串类型"
    fun isString(){
        println(str is String)
        println(str !is String)
    }
}

fun main() {
    Is().isString()
}
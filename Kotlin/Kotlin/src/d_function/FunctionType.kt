package d_function


class FunctionType {
    /**我们通常使用的函数传递,指的是参数传值,函数需要返回一个对象,其他函数可以将该返回对象传入体内,实现逻辑交换
     * 但在kotlin中,由于所有对象均可以被var,val声明,我们也可以直接对方法对象进行传递
     * */

    /**思考:这里的实际返回类型是什么?
     *  function type
     *  将方法作为参数或者返回值的函数称之为高阶函数
     * */
    fun toSeconds(time: String): (Int) -> Int = when (time) {
        "hour" -> { value -> value * 60 * 60 }
        "minute" -> { value -> value * 60 }
        "second" -> { value -> value }
        else -> { value -> value }
    }
}

fun main() {
    val list= listOf(1,2,3,4,5)
    var functionLogic=FunctionType().toSeconds("minute")
    //因为返回值是function type(可以看成一个匿名函数)
    var transmitAfter=list.map(functionLogic)
    println(transmitAfter)
}
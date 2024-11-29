package d_function

class FunctionParameter {
    /**普通函数*/
//    fun method(num:Int,num_default:Int=10):Int{
//        return num+num_default
//    }
    /**无返回值函数*/
    fun voidMethod():Unit{}//:Unit可省略
    /**单表达式函数(等价于上面的)*/
    fun method(num:Int,num_default: Int=10)=num+num_default

    /**匿名函数*/
    var anonymity={num:Int,num_default:Int -> num+num_default}/*匿名函数的参数不可以使用单表达式形式*/
}

fun main() {
    val obj=FunctionParameter()
    println(obj.method(2))
    println(obj.method(2,1))
    println(obj.anonymity(1,2))
}
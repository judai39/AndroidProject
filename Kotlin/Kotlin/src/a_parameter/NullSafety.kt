package a_parameter

/**由于kotlin中的任何对象都要有运行类型,因此,对于那些没能正确实例的对象,系统会分配一个安全值null,在编程时,要注意
 *显式声明程序中何时允许值。null
 *检查值。null
 *对可能包含值的属性或函数使用安全调用。null
 *声明检测到值时要执行的操作。null
 * */

class NullSafety {

    fun describeString(mayBeNull:String?):String{
        if (mayBeNull!=null && mayBeNull.isNotEmpty()){
            return mayBeNull
        }
        else{
            return "Empty Or Null String"
        }
    }

    fun lengthSting(mayBeNull: String?):Int?=mayBeNull?.length

}

fun main() {
    /**声明何时允许null值(编译类型声明为?)*/
    var neverNull="已被实例化的值不可以被置空"
//    neverNull=null
    var mayBeNull:String?="初始化类型不知道到底是不是空值可以置空"
    mayBeNull=null

    /**检查null*/
    print(NullSafety().describeString(null))


    /**安全调用*/
    NullSafety().lengthSting(null)
    NullSafety().lengthSting("not null")

    val nullString: String? = null
    println(nullString?.uppercase())    //null


}
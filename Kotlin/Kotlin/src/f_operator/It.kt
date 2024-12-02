package f_operator

/**常用于高阶函数中的调用者指向,与this作为比较
 * this 带接收者函数类型(thisOperator.fun() , 这里的this指代的就是接收者)
 * it   带参函数类型(fun(itOperator) , 这里的it指代的是参数对象)
 *
 * 无论是哪一个传递类型,目的都是为了将fun传递过去,并且还要告知"谁对这个函数负责"这件事
 * */

class It {
    open class Person{
        fun doSomething(str:String){
            println("just so $str")
        }
        fun getString():String{return "this is a str"}
    }
}
fun <T: It.Person> T.testThis(function:T.() -> Unit){
    function()
}

fun <T: It.Person> T.testIt(function:(T)->Unit){
    function(this)
}
fun main() {
    var person= It.Person()
    person.testThis { println(this) }//f_operator.It$Person@266474c2
    person.testIt { println(it) }//f_operator.It$Person@266474c2

    person.testThis { person.doSomething(this.getString()) }
    person.testIt { person.doSomething(it.getString()) }
}


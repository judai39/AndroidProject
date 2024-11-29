package d_function

import javax.swing.text.View

/**将函数作为函数的参数,返回值的函数成为高阶函数*/
class HigherOrderFunction {
    //作为参数
    fun method1(toStr:(Int)->String){
        println(toStr(1))
    }
    /**尝试一下重写onClick()*/
    private lateinit var onClick:(View)->Unit   //'lateinit' allows initializing a not-null property outside of a constructor
    fun setOnClickListener(onClick:(View)->Unit){
        this.onClick=onClick
    }
}

fun main() {
    var obj=HigherOrderFunction()
    //作为参数
    obj.method1 {"1"}//等价于obj.method1({"1"}) 等价于obj.method1("fun toString(num:Int){num.toString()}")

    /**尝试一下重写onClick()*/
    obj.setOnClickListener { /*doSomeThing(View)*/ }
}
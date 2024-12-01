package d_function

/**Lambda函数是function type的一个实例*/
class LambdaFunction {
    fun method1(num:Int,function:(String)->Unit){//Unit 类似于<Void>,告知编译器不需要返回值类型
        function("")//调用作为参数的lambda函数时要加上对应的后缀形参
    }

    fun method2(function: (String) -> Unit){
        function("")
    }
}

fun main() {
    var obj=LambdaFunction()
    var functionType={x:Int,y:Int->x+y}
    println(functionType(1,2))
    /**Lambda函数的一些特点*/
    //(1)、如果Lambda是函数的最后一个参数，可以将Lambda写在括号外面
    var functionType1={str:String-> println(str)}
    obj.method1(1){ functionType1("ddd")}
    //(2)、如果Lambda是函数唯一的参数，还可以将括号去掉
    obj.method2{functionType1("ddd")}
    //(3)、如果Lambda内部没有参数，可以用小括号：
    obj.method2(functionType1)
    //(4)、如果Lambda内部只有一个参数，可以省略掉不写,需要使用这个参数时用it调用
    obj.method2{/*strIt:String->*/ println("现在不需要,现在需要了$it.strIt")}
    /**注:省略参数仅适用于实例中的成员传参,因为具体的参数类型在class中已有记载才能省略
     * var function2={println(it.str)}  错,无法的值该function type的参数类型
     * */



}
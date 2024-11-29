package d_function

class LambdaFunction {
    /**Lambda函数时function type的实例*/
}

fun main() {
    var functionType={x:Int,y:Int->x+y}
    print(functionType(1,2))
}
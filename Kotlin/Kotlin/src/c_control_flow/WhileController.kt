package c_control_flow

class WhileController {

}

fun main() {
    var num1=0
    var num2=0
    while(num1<2){
        num1++
    }
    do {
        num2++
    }while (num2<2)

    println("num1=$num1 num2=$num2")
}
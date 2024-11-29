package c_control_flow

class ForController {

}

fun main() {
    /**遍历range*/
    for (number in 1..5){
        print("$number ")
    }
    /**遍历list*/
    for (number in listOf("1","2","3","4","5")){
        print("$number ")
    }

}
package f_operator.punctuation

fun main() {
    val num:Int=2

    /**==比较数值,===比较地址*/

    val num1=num
    val num2=num
    println(num1==num2) //true
    println(num1===num2)//true

    val num3:Int?=num
    val num4:Int?=num
    println(num3==num4)
    println(num3===num4)
}
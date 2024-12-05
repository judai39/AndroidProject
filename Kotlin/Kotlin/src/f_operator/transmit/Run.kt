package f_operator.transmit

/**run结合了let,with两种功能
 * 1,surround后无需调用直接使用成员
 * 2,统一判空
 * 3,定义一个变量在特定作用域
 * */

class StudentRun{
    fun say()=print("hello")
    fun eat()= print("have a lunch")
    fun sleep()= print("have a sleep")
}

fun main() {
    var student=StudentRun()
    /**返回值是最后一行(return)*/
    var num=student?.run {
        say()
        eat()
        sleep()
        999
    }
}
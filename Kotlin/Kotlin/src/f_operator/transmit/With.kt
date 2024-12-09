package f_operator.transmit

/**在调用一个实例对象的成员时,可以使用with包围,在代码块中直接使用(无需调用)*/
class StudentWith{
    fun say()=print("hello")
    fun eat()= print("have a lunch")
    fun sleep()= print("have a sleep")
}

fun main() {
    var student=StudentWith()
    with(student){
        say()
        eat()
        sleep()
    }
}
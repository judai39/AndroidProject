package f_operator.transmit

/**类似于let,区别于返回值*/
class StudentAlso{
    fun say()=print("hello")
    fun eat()= print("have a lunch")
    fun sleep()= print("have a sleep")
}

fun main() {
    val student=StudentAlso()
    /**返回值是it本身*/
    var num=student.also {
        it.eat()
        it.say()
        it.sleep()
        999
    }
    print(num)
}
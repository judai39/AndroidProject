package f_operator.transmit

/**apply结合了run,also,返回值是this*/

class StudentApply {
    fun say()=print("hello")
    fun eat()= print("have a lunch")
    fun sleep()= print("have a sleep")
}

fun main() {
    var student=StudentApply()
    /**返回值是this*/
    var obj=student.apply {
        say()
        eat()
        sleep()
        999
    }
}
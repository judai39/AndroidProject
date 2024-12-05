package f_operator.transmit

/**返回值为代码块最后一句*/
class Student{
    fun say()=print("hello")
    fun eat()= print("have a lunch")
    fun sleep()= print("have a sleep")
}

fun main() {
    //作用1:使用it替代object对象去访问其公有的属性和方法
    val student=Student()
    student.let {
        it.say()
        it.eat()
        it.sleep()
    }
    //作用2:自动判断null传递
    student?.let {
        it.say()
        it.eat()
        it.sleep()
    }//如果student对象不为空,则调用

    /**返回值为最后的表达式return*/
    val num=student.let {
        it.say()
        it.eat()
        it.sleep()
        999
    }
    println(num)
}
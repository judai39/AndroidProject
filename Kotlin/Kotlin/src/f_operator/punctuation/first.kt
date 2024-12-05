package f_operator.punctuation

class Student{
    lateinit var name:String

    fun set(name:String){
        this.name=name
    }

    fun get():String{
        return this.name
    }
}

fun main() {
    var student=Student()
    /**A?:B符号的含义是,如果A为空,则返回B的值给A*/
    student?:student.let {
        it.set("小明")
        it.get()
    }
}
package f_operator

/**Class? 也是一种类型,可以作为返回值,其他类或本类成员在接收这个值时需要对?判断做出处理,否则需要继续传递下去*/

class NullTransmit {
    open class Book(var name:String)
    open class Student(var name:String){
        fun action(book:Book?/*将空值判断作为参数,除非对判断做处理,否则需要继续return Book?类型传递下去*/){
            //做出处理
            if (book==null){
                println("${name}没在看书")
            }else{
                println("${name}在看${book.name}")
            }
        }
    }
    fun seeBook(){
        var student=Student("小明")
        var book=Book("三国演义")
        student.action(null)
        student.action(book)
    }
}

fun main() {
    var obj=NullTransmit()
    obj.seeBook()
}
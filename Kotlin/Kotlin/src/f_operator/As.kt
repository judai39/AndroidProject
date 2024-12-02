package f_operator

/**as运算符用以类型的显示转换*/

class As {
    open class Fruit
    open class Apple(private var name: String) : Fruit() {
        fun eat() {
            println("吃" + this.name)
        }
        fun getName():String{return this.name}
        fun setName(name:String){this.name=name}
    }

    fun asFruit() {
        val apple: Apple = Apple("apple")

        println(apple as Fruit)
        apple as? Fruit

    }
}

fun main() {
    As().asFruit()
}
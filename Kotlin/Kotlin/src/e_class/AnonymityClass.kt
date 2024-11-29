package e_class


class AnimalImp : Animal {
    override fun say() {
        println("动物都会叫")
    }
}

interface Animal {
    fun say()
}

fun main() {
    AnimalImp().say()
    val cat = object : Animal {
        override fun say() {
            println("小猫喵喵叫")
        }
    }
    cat.say()


}
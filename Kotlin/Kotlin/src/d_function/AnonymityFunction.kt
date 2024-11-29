package d_function

/**一切对象均有类型,且均可以被var,val声明(这也符合kotlin的万物皆实例的要求)*/
class AnonymityFunction {
    /**使用匿名函数的作用--处理额外逻辑*/
    val numbers= listOf(1,2,3,4,5,6,7,8)
    //1.使用List.filter()过滤
    val listFilter={list:List<Int> -> list.filter { x->x>5 }}
    //等价于
    val numberFilter=numbers.filter { x -> x>5 }


    //2.使用List.map() 转换
    val listMap=numbers.map { x->x*2 }
    //等价于
    private val listMap1={ x:Int->x*2}
    val result=numbers.map(listMap1)


}

fun main() {
    val obj=AnonymityFunction()
    println(obj.listFilter(obj.numbers))
    println(obj.numberFilter)

    println(obj.listMap)

    //1.单独调用(Lambda 表达式可以通过在大括号后添加括号并在括号内包含任何参数来自行调用)
    println({text:String -> text.uppercase()}("hello"))

    //2.尾随Lambda(如果一个方法中的参数仅有一个function type的话,可以将该lambda参数移到该方法后面进行尾随out of parentheses)
    //fold(初始值,一个操作)
    println(listOf(1, 2, 3).fold(0, { x, item -> x + item }))

    println(listOf(1, 2, 3).fold(0) { x, item -> x + item })
}
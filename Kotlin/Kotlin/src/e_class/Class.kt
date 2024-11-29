package e_class

/**思考:使用类的目的是什么
 * 以一种特定的逻辑存储并处理数据,以便于我们重复调用
 * */

class Class(/*类标题,等价于构造函数*/var parameterName:String="default_name",val parameterValue:Int=0) {
    var category:String="work"
    fun print(str:String=""){
        println("打印属性的方法$str")
    }
}

fun main() {
    /**来创建一个实例对象吧*/
    val obj=Class("我是一个类",20)

    /**修改一些类的属性(注意声明为var)*/
    obj.parameterName="我的名字被修改了"
    obj.category="创建第一个类"

}
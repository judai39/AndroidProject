package c_control_flow

class IfController {
    fun test(){
        val d:Int
        val check:Boolean=true
        if(check){
            d=1
        }else{
            d=2
        }
        print(d)
    }
}

fun main() {
    val obj=IfController()
    obj.test()
    //控制流可以直接输出,有返回值(准确说应该是kotlin是一个填充实例的包装类,一切对象均要有实例对象)
    val a=1
    val b=2
    print(if(a>b)a else b)
}
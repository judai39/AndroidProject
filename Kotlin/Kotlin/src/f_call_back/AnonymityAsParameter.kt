package f_call_back

/**对象A将匿名类B作为参数,在B中回调对象A*/

class AnonymityAsParameter {
    var num=1
    fun method(num:Int){
        this.num=num
    }
    fun methodR(obj:AnonymityAsParameter){

    }
}

fun main() {
    val obj=AnonymityAsParameter()

}
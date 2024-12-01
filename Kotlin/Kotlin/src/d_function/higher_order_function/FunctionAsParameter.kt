package d_function.higher_order_function


/**kotlin支持函数类型作为数据传入或传出,这样有什么好处?*/
class FunctionAsParameter {
    /**1.在java中实现类似与函数类型作为参数的效果*/
    //public interface OnClickListener{
    //    void onClick(View view)
    //}
    //
    //OnClickListener onClickListener=new OnClickListener{
    //  	@Override
    //  	public void onClick(View view){
    //  	  doSomething();
    //    }
    //}
    //view.setOnClickListener(onClickListener);
    /**2.在kotlin中将函数类型作为参数(核心是要获取一个函数的实例对象,在main中传入调用方法中)*/
    fun methodA(arg:(Int)->String):String{return arg(1)}
    /**思考,这里的methodA()参数是?  是一个fun(int):String的函数类型,但传入参数也可以是String类型
     * 因为String类型也可以看成是fun(Unit):String的一个函数类型
     * */
    private fun methodB(arg:Int):String{return arg.toString()}

    //如何获取函数实例?
    var functionInstance1=methodA(::methodB)//双冒号获取(此时是String类型)
    var functionInstance2=methodA(fun(arg:Int):String{return arg.toString()})//匿名函数获取
}

fun main() {
    /**2.在kotlin中将函数类型作为参数*/
    var obj=FunctionAsParameter()
    println(obj.methodA { obj.functionInstance1 })
    println(obj.methodA { obj.functionInstance2 })
}
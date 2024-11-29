package e_class

/**kotlin中有专门用以存放数据的对象声明data
 * data class student{
 *      等价于我们在框架中的一些创建对象的最小单位(Student,Account...)
 * }
 * */

data class Student(val name:String="stu_name",val id:Int) {
    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }
}

fun main() {
    var student1=Student("小明",1)
    var student2=Student("大明",2)
    println(student1)//调用override toString()
    println(student1==student2)//调用 override equals(obj)
    println(student1.copy(name = "复制名字"))//调用 override copy(parameter)
}
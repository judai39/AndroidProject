package zzz_design_patterns.create.singleton

import javax.naming.Context

//以Volley的单例创建举例
class SingletonTest private constructor(context: Context){
    companion object{
        private var INSTANCE:SingletonTest?=null
        fun getInstance(context:Context){
            INSTANCE?: synchronized(this){
                SingletonTest(context).also { INSTANCE=it }
            }
        }
    }
}
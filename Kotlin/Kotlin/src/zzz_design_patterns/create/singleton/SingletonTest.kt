package zzz_design_patterns.create.singleton

import javax.naming.Context

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
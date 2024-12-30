package com.haoyudu.roomcrud.util


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build
import androidx.annotation.RequiresApi

//@RequiresApi(Build.VERSION_CODES.P)
class DBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    constructor(context: Context?):this(context,"db_helper", null,1 )

    private companion object{
        var createSql="CREATE TABLE student_tbl(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VARCHAR(20),CLASSMATE VARCHAR(30),AGE INTEGER)"
        var deleteSql="DROP TABLE IF EXIST student_tbl"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DBHelper.createSql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DBHelper.deleteSql)
    }
}
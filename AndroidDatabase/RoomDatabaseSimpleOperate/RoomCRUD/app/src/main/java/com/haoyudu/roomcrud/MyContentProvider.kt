package com.haoyudu.roomcrud

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import com.haoyudu.roomcrud.util.DBHelper

class MyContentProvider : ContentProvider() {
    lateinit var db:SQLiteDatabase


    companion object{
        class Matcher(){
            fun get_matcher(AUTHORITY:String, dir:Int, item:Int) : UriMatcher{
                val matcher = UriMatcher(UriMatcher.NO_MATCH)
                matcher.addURI(AUTHORITY, "student", dir)
                matcher.addURI(AUTHORITY, "student/#", item)
                return matcher
            }
        }
        val STUDENT_DIR=0
        val STUDENT_ITEM=1
        var AUTHORITY="com.haoyudu.roomcrud"
        val uriMatcher=Matcher().get_matcher(AUTHORITY, STUDENT_DIR, STUDENT_ITEM)
    }


    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        var count=0
        when (uriMatcher.match(uri)){
            STUDENT_DIR->{
                count=db.delete("student_tbl",selection,selectionArgs)
            }
            STUDENT_ITEM->{
                val id=uri.pathSegments.get(1)
                count=db.delete("student_tbl","id=?", arrayOf(id.toString()))
            }
        }
        return count
    }

    override fun getType(uri: Uri): String? {
        /**MIME type是为了让android系统知道能够处理的数据是单条记录还是整体*/
        /**MIME特点:
         *      1.以vnd开头
         *      2.如果uri以路径结尾,后面接android.cursor.dir
         *      3.如果uri以id结尾,后面接android.cursor.item
         *      4.最后接的内容为 vnd.<authority>.<path>
         * */
        when(uriMatcher.match(uri)){
            STUDENT_DIR->{
                return "vnd.android.cursor.dir/vnd.$AUTHORITY.student"
            }
            STUDENT_ITEM-> {
                return "vnd.android.cursor.item/vnd.$AUTHORITY.student"
            }
        }
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        var uriNew: Uri? =null
        val newId:Long
        when(uriMatcher.match(uri)){
            STUDENT_ITEM->{
                newId=db.insert("student_tbl",null,values)
                uriNew=Uri.parse("content://${AUTHORITY}/student/+${newId}")

            }
            STUDENT_DIR->{
                newId=db.insert("student_tbl",null,values)
                uriNew=Uri.parse("content://${AUTHORITY}/student/+${newId}")
            }
        }
        return uriNew
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(): Boolean {
        val dbHelper=DBHelper(context)
        db=dbHelper.writableDatabase
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        var cursor:Cursor?=null
        when(uriMatcher.match(uri)){
            STUDENT_ITEM->{
                val id=uri.pathSegments.get(1)
                cursor=db.query("student_tbl",projection,"id=?", arrayOf(id.toString()),null,null,sortOrder)
            }
            STUDENT_DIR->{
                cursor=db.query("student_tbl",projection,selection,selectionArgs,null,null,sortOrder)
            }
        }
        return cursor
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        var count=0
        when(uriMatcher.match(uri)){
            STUDENT_DIR->{
                count=db.update("student_tbl",values,selection,selectionArgs)
            }
            STUDENT_ITEM->{
                val id=uri.pathSegments.get(1)
                count=db.update("student_tbl",values,"id=?", arrayOf(id.toString()))
            }
        }
        return count
    }
}
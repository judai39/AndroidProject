package com.haoyudu.inputoutputfirst

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toBitmap
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.Exception
import java.nio.charset.StandardCharsets
import java.util.*

class MainActivity : AppCompatActivity() {
    var testStr: String = "to be initialized"

    //    val filePath="${application.filesDir.absolutePath}/test.txt"      尝试在onCreate外声明，系统无法获取application实例
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var filePath = "${application.filesDir.absolutePath}/"
        /**写入,读取文字*/
//        filePath += "test.txt"
//        val calendar = Calendar.getInstance()
//        testStr = "测试数据为${calendar.get(Calendar.YEAR)}-${calendar.get(Calendar.MONTH)}-${calendar.get(Calendar.DAY_OF_MONTH)}-${calendar.get(Calendar.HOUR_OF_DAY)}"
//
//        btn_output_data.setOnClickListener {
//            File(filePath).writeText(testStr)
//        }
//        btn_input_data.setOnClickListener {
//            //readText : 读取文本形式的文件内容。
//            //readLines : 按行读取文件内容。返回一个字符串的List，文件有多少行，队列中就有多少个元素。
//            //readBytes : 读取字节数组形式的文件内容。
//            var data = File(filePath).readText()
//            data = File(filePath).readLines()[0]
//            data = File(filePath).readBytes()[0].toString()      //返回-26（常用于返回图片字节码，再进行解析）
//            textView.text = data
//        }

        /**写入,读取图片*/
//        filePath+="test.png"
//        btn_output_data.setOnClickListener{
//            val bitmap=getDrawable(R.drawable.img)?.toBitmap()
//            if (bitmap != null) {
//                FileUtil.saveImage(filePath,bitmap = bitmap)
//            }
//        }
//
//        btn_input_data.setOnClickListener{
//            //文件的读取三种形式
//
//            //1.通过解析字节数组ByteArray
////            val bytes=File(filePath).readBytes()
////            val bitmap=BitmapFactory.decodeByteArray(bytes,0,bytes.size)
//
//
//            //2.通过解析输出流获取
////            val inputStream=File(filePath).inputStream()
////            val bitmap=BitmapFactory.decodeStream(inputStream)
////            inputStream.close()
//
//
//            //3.从路径直接获取
//            val bitmap=BitmapFactory.decodeFile(filePath)
//
//
//            imageView.setImageBitmap(bitmap)
//        }

        /**遍历路径中所有图片*/
        val fileName: MutableList<String> = mutableListOf()
        val fileTree: FileTreeWalk = File(filePath).walk()
        fileTree.maxDepth(1).filter { it.isFile }.filter { it.extension in listOf("png", "jpeg") }
            .forEach { fileName.add(it.name) }
        for (i in fileName){
            println(i)
        }
    }

    object FileUtil {
        fun saveImage(path: String, bitmap: Bitmap) {
            try {
                val file = File(path)
                //获取文件的输出流对象,用以压缩目标文件
                val fos: OutputStream = file.outputStream()
                //存储图片(可选择压缩格式)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                fos.flush()
                fos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

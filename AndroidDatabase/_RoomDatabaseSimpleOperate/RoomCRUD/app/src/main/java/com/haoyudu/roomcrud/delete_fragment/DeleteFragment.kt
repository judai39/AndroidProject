package com.haoyudu.roomcrud.delete_fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import com.haoyudu.roomcrud.R
import com.haoyudu.roomcrud.dao.StudentDao
import com.haoyudu.roomcrud.entity.Student
import kotlinx.android.synthetic.main.fragment_delete.*
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DeleteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DeleteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        delete_btn_clear.setOnClickListener {
            delete_edit.text=null
        }

        delete_btn_confirm.setOnClickListener {
            AlertDialog.Builder(requireContext()).apply {
                //构建一个对话框
                //apply标准函数自动返回调用对象本身
                try {
                    val student=StudentDao(requireContext()).queryStudent(delete_edit.text.toString().toInt())
                    setTitle("确认删除${student?.name}同学的信息吗")//表示
                    setMessage("学号")//内容
                    setCancelable(false)//是否使用Back关闭对话框
                    setPositiveButton("ok"){ _, _ ->
                        StudentDao(requireContext()).delete(delete_edit.text.toString().toInt())
                        Handler().postDelayed(object:Runnable{
                            override fun run() {
                                Navigation.findNavController(delete_btn_confirm).navigate(R.id.mainFragment)
                            }
                        },3000)
                    }
                }catch (e:Exception){
                    Toast.makeText(requireContext(),"未找到该用户",Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("取消"){ //设置取消按钮
                        _, _ ->
                    Toast.makeText(requireContext(),"取消删除",Toast.LENGTH_SHORT).show()
                }
                show()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DeleteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DeleteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
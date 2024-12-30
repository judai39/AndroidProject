package com.haoyudu.roomcrud.main_fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.haoyudu.roomcrud.R
import com.haoyudu.roomcrud.adapter.StudentAdapter
import com.haoyudu.roomcrud.dao.StudentDao
import com.haoyudu.roomcrud.entity.Student
import com.haoyudu.roomcrud.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter= StudentAdapter()
        val datas:List<Student> = StudentDao(requireContext()).queryAll()
        adapter.setOnItemClickListener(object: StudentAdapter.OnItemClickListener{
            override fun onItemClickListener(view: View, position: Int) {
                Toast.makeText(requireContext(),"您点击了第${position+1}条数据:${datas[position]}", Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView.apply {
            this.adapter=adapter
            layoutManager= LinearLayoutManager(context)
        }

        val studentViewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(requireActivity().application)).get(StudentViewModel::class.java)
        studentViewModel._studentLiveData.observe(this) {
            adapter.setStudents(it)
            adapter.notifyDataSetChanged()
        }

        btn_add.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.insertFragment)
        }

        btn_delete.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.deleteFragment)
        }

        btn_upgrade.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.upgradeFragment)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
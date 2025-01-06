package com.haoyudu.roomcrud.upgrade_fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import com.haoyudu.roomcrud.R
import com.haoyudu.roomcrud.dao.StudentDao
import kotlinx.android.synthetic.main.fragment_upgrade.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UpgradeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpgradeFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_upgrade, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        upgrade_btn_select.setOnClickListener {
            try {
                val student=StudentDao(requireContext()).queryStudent(upgrade_edit.text.toString().toInt())
                to_upgrade_student_layout.visibility=View.VISIBLE
                upgrade_stu_id.text=student.id.toString()
                upgrade_stu_name.text=student.name
                upgrade_stu_age.text=student.age.toString()
            }catch (e:Exception){
                Toast.makeText(requireContext(),"未找到该用户",Toast.LENGTH_SHORT ).show()
            }
        }
        upgrade_stu_name.setOnClickListener {
            val bundle=Bundle()
            bundle.putString("toUpgradePara",upgrade_stu_name.text.toString())
            Navigation.findNavController(it).navigate(R.id.nameFillFragment,bundle)
        }
        upgrade_stu_age.setOnClickListener {
            val bundle=Bundle()
            bundle.putString("toUpgradePara",upgrade_stu_age.text.toString())
            Navigation.findNavController(it).navigate(R.id.ageFillFragment,bundle)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UpgradeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UpgradeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
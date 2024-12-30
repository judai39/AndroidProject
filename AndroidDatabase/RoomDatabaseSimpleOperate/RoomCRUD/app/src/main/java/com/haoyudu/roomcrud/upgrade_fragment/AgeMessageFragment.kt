package com.haoyudu.roomcrud.upgrade_fragment

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
import kotlinx.android.synthetic.main.fragment_age_message.*
import kotlinx.android.synthetic.main.fragment_name_message.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgeMessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgeMessageFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_age_message, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val toUpgrade=arguments?.getString("toUpgradePara")
        fill_age_btn_upgrade.setOnClickListener {
            try {
                Toast.makeText(requireContext(),"修改成功", Toast.LENGTH_SHORT).show()
                StudentDao(requireContext()).updateAge(toUpgrade.toString(),fill_age_edit_upgrade.text.toString())
            }catch (e:Exception){
                Toast.makeText(requireContext(),"修改失败", Toast.LENGTH_SHORT).show()
            }finally {
                Handler().postDelayed({ Navigation.findNavController(it).navigate(R.id.mainFragment) },3000)
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
         * @return A new instance of fragment AgeMessageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AgeMessageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
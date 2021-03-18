package com.example.mjchotelmanagementsystem.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mjchotelmanagementsystem.R
import com.example.mjchotelmanagementsystem.helper.Utils


class HomeFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root=inflater.inflate(R.layout.fragment_home, container, false)
        val button_chkinout: Button =root.findViewById(R.id.button_check_in_out)
        val button_mybooking: Button =root.findViewById(R.id.button_my_booking)
        val button_order: Button =root.findViewById(R.id.button_order)




        button_chkinout.setOnClickListener{
            findNavController().navigate(R.id.action_nav_home_to_nav_checkInOut)

        }

        button_mybooking.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_myBooking)
        }

        button_order.setOnClickListener {
            Utils.toast(requireActivity(), "ORDER", 0)

        }
        return root

    }


   override fun onDestroy() {

        super.onDestroy()
        /*val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = HomeFragment()
        fragmentTransaction.remove(R.id.fragment_home, fragment)
        fragmentTransaction.commit()*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
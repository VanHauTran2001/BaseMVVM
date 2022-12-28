package com.example.basemvvm.base.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basemvvm.base.activity.BaseActivity

open class BaseFragment : Fragment() {
    protected fun navigateToPage(actionID : Int){
        findNavController().navigate(actionID)
    }

    protected fun showLoading(isShow : Boolean){
        val activity = requireActivity()
        if (activity is BaseActivity){
            activity.showLoading(isShow)
        }
    }
   
}
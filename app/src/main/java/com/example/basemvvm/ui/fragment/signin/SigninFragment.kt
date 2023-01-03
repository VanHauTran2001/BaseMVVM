package com.example.basemvvm.ui.fragment.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.basemvvm.base.fragment.BaseFragment
import com.example.basemvvm.databinding.FragmentSigninBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SigninFragment : BaseFragment(){
    private lateinit var binding : FragmentSigninBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogin.setOnClickListener {
//            val action = SigninFragmentDirections.actionSigninFragmentToHomeFragment()
//            findNavController().navigate(action)
        }
    }
}
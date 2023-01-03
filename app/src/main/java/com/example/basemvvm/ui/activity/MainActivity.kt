package com.example.basemvvm.ui.activity

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.basemvvm.R
import com.example.basemvvm.base.activity.BaseActivity
import com.example.basemvvm.databinding.ActivityMainBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private var binding : ActivityMainBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

    }

    override fun showLoading(isShow: Boolean) {
        binding!!.loadingLayout.visibility = if(isShow) View.VISIBLE else View.GONE
    }
}
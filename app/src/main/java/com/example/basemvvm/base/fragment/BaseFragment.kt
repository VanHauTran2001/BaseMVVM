package com.example.basemvvm.base.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.basemvvm.R
import com.example.basemvvm.base.activity.BaseActivity
import com.example.basemvvm.base.network.BaseNetWorkException
import com.example.basemvvm.base.viewmodel.BaseViewModel
import com.example.basemvvm.common.EventObserver

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
    protected fun showErrorMessage(e: BaseNetWorkException) {
        showErrorMessage(e.mainMessage)
    }
    protected fun showErrorMessage(messageId: Int){
        val message = requireContext().getString(messageId)
        showErrorMessage(message)
    }
    protected fun showErrorMessage(message: String){
        val activity = requireActivity()
        if (activity is BaseActivity) {
            activity.showErrorDialog(message)
        }
    }
    protected fun showNotify(title: String?, message: String) {
        val activity = requireActivity()
        if (activity is BaseActivity) {
            activity.showNotifyDialog(title ?: getDefaultNotifyTitle(), message)
        }
    }
    protected fun registerObserverExceptionEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.baseNetworkException.observe(viewLifecycleOwner, EventObserver {
            showErrorMessage(it)
        })
    }
    protected fun registerObserverNetworkExceptionEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.networkException.observe(viewLifecycleOwner, EventObserver {
            showNotify(getDefaultNotifyTitle(), it.message ?: "Network error")
        })
    }
    protected fun registerObserverMessageEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.errorMessageResourceId.observe(viewLifecycleOwner, EventObserver { message ->
            showErrorMessage(message)
        })
    }
    private fun getDefaultNotifyTitle(): String {
        return getString(R.string.default_notify_title)
    }
    protected fun registerObserverLoadingMoreEvent(viewModel: BaseViewModel,
                                                   viewLifecycleOwner: LifecycleOwner){
        viewModel.isLoadingMore.observe(viewLifecycleOwner,EventObserver{
                isShow->
            showLoadingMore(isShow)
        })
    }
    protected fun showLoadingMore(isShow: Boolean){

    }
    protected fun registerAllExceptionEvent( viewModel: BaseViewModel,
                                             viewLifecycleOwner: LifecycleOwner){
        registerObserverExceptionEvent(viewModel,viewLifecycleOwner)
        registerObserverNetworkExceptionEvent(viewModel,viewLifecycleOwner)
        registerObserverMessageEvent(viewModel,viewLifecycleOwner)
    }

    protected fun registerObserverLoadingEvent(viewModel: BaseViewModel,viewLifecycleOwner: LifecycleOwner){
        viewModel.isLoading.observe(viewLifecycleOwner,EventObserver{
                isShow ->
            showLoading(isShow)
        })
    }
}
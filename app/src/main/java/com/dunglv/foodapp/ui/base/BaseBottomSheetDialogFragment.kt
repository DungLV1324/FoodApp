package com.dunglv.appmusic.ui.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.dunglv.foodapp.MainActivity
import com.dunglv.foodapp.R
import com.dunglv.foodapp.ui.homemain.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialogFragment<B : ViewDataBinding> :
    BottomSheetDialogFragment() {
    lateinit var binding: B
    private lateinit var mainViewModel: MainViewModel
    abstract val layoutId: Int

    override fun onDestroyView() {
        super.onDestroyView()
    }

    protected abstract fun onCreatedView(view: View?, savedInstanceState: Bundle?)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        onCreatedView(view, savedInstanceState)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomCreateStoryStyle)
    }


    override fun onPause() {
        super.onPause()
        dialog?.window?.setWindowAnimations(-1)
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            dialogInterface.behavior.isDraggable = false
        }
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
//        dialog.window?.setDecorFitsSystemWindows(false)
        return dialog
    }
    open fun navigateFragment(id: Int) {
        val navController = (requireActivity() as MainActivity).navController
        navController.navigate(id)
    }
}
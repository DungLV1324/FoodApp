package com.dunglv.foodapp.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.dunglv.foodapp.MainActivity;
import com.dunglv.foodapp.ui.homemain.MainViewModel;


public abstract class BaseBindingDialogFragment<B extends ViewDataBinding> extends BaseDialogFragment {
    public B binding;

    public MainViewModel mainViewModel;

    public abstract int getLayoutId();

    protected abstract void onCreatedView(View view, Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        onCreatedView(view, savedInstanceState);

    }
    public void navigateFragment(int id){
        NavController navController =((MainActivity)requireActivity()).getNavController();
        navController.navigate(id);
    }


}

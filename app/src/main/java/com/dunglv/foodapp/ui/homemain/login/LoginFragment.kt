package com.dunglv.foodapp.ui.homemain.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dunglv.foodapp.R
import com.dunglv.foodapp.api.LoginApi
import com.dunglv.foodapp.api.RestClient
import com.dunglv.foodapp.common.Constant
import com.dunglv.foodapp.data.model.LoginResponse
import com.dunglv.foodapp.databinding.FragmentLoginBinding
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class LoginFragment : BaseBindingFragment<FragmentLoginBinding, MainViewModel>() {

    private var retrofit = RestClient.getRetrofit()

    private val endPointAPI = retrofit.create(LoginApi::class.java)

    private lateinit var sharedPreferences: SharedPreferences

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_login
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        callBackApiLogin()
        onClick()

    }

    private fun onClick() {
        binding.tvTitleSingUp.setOnClickListener {
            navigateFragment(R.id.fragment_singup)
        }
    }

    private fun callBackApiLogin() {

        binding.tvLoginApp.setOnClickListener {
            val call = endPointAPI.login(
                binding.edUserName.text.toString(),
                binding.edPassWord.text.toString()
            )
            call.enqueue(object : Callback<LoginResponse> {
                @SuppressLint("SuspiciousIndentation", "BinaryOperationInTimber")
                override fun onResponse(
                    call: Call<LoginResponse>?, response: Response<LoginResponse>?
                ) {
//                    Timber.tag("TAG").e("onResponse: %s", response?.body()?.message)

                    if (response?.body()?.status == true) {
                        saveToken(response.body()?.data?.token)
                        Timber.tag("TAG").e("onResponse: " + response.body()?.data?.token)

//                        Bundle().apply {
//                            putString(Constant.KEY_TOKEN, response.body()?.data?.token)
                            navigateFragment(R.id.fragment_main)
//                        }
                    } else {
                        Toast.makeText(
                            requireContext(), "Username or password is incorrect",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                    t?.printStackTrace()
                }
            })
        }
    }

    private fun saveToken(token: String?) {
        sharedPreferences = requireActivity().getSharedPreferences("myapp", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor?.putString("token", token)
        editor?.apply()
    }
}
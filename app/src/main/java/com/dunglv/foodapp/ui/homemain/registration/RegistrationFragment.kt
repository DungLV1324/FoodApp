package com.dunglv.foodapp.ui.homemain.registration

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.dunglv.foodapp.R
import com.dunglv.foodapp.api.RestClient
import com.dunglv.foodapp.api.SingUpApi
import com.dunglv.foodapp.data.model.SingUpResponse
import com.dunglv.foodapp.databinding.FragmentSingupBinding
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationFragment : BaseBindingFragment<FragmentSingupBinding, MainViewModel>() {
    private var retrofit = RestClient.getRetrofit()

    private val endPointAPI = retrofit.create(SingUpApi::class.java)

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_singup
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.tvNextApp.setOnClickListener {
            val call = endPointAPI.singUp(
                binding.edUserName.text.toString(),
                binding.edPhoneNumber.text.toString(),
                binding.edEmail.text.toString(),
                binding.edPassWord.text.toString()
            )

            call.enqueue(object : Callback<SingUpResponse> {
                override fun onResponse(
                    call: Call<SingUpResponse>?,
                    response: Response<SingUpResponse>?
                ) {
                    Log.d("TAG", "onResponseR: " + response?.body()?.status)

                    if (response?.body()?.status == true) {
                        navigateFragment(R.id.fragment_login)
                        Log.d("TAG", "onResponseR: " + response?.body()?.status)

                    } else {
                        Toast.makeText(requireContext(), "The username or email has already been taken.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                override fun onFailure(call: Call<SingUpResponse>?, t: Throwable?) {
                    t?.printStackTrace()
                }
            })
        }
    }
}
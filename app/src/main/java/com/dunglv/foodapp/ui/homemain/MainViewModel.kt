package com.dunglv.foodapp.ui.homemain

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dunglv.foodapp.R
import com.dunglv.foodapp.api.DetailApi
import com.dunglv.foodapp.api.HomeApi
import com.dunglv.foodapp.api.RestClient
import com.dunglv.foodapp.data.model.DataDetail
import com.dunglv.foodapp.data.model.DataProducts
import com.dunglv.foodapp.data.model.DetailFoodResponse
import com.dunglv.foodapp.data.model.HomeResponse
import com.dunglv.foodapp.data.model.Intro
import com.dunglv.foodapp.data.model.Products
import com.dunglv.foodapp.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainViewModel : BaseViewModel() {

    private var _listIntroLiveData: MutableLiveData<List<Intro>> = MutableLiveData()
    val listIntroLiveData: MutableLiveData<List<Intro>>
        get() = _listIntroLiveData
    private var _listSearchLiveData: MutableLiveData<List<DataProducts>?> = MutableLiveData()
    val listSearchLiveData: MutableLiveData<List<DataProducts>?>
        get() = _listSearchLiveData

    private var _listBellLiveData: MutableLiveData<List<DataProducts>?> = MutableLiveData()
    val listBellLiveData: MutableLiveData<List<DataProducts>?>
        get() = _listBellLiveData

    private var _listPopulerLiveData: MutableLiveData<List<DataProducts>?> = MutableLiveData()
    val listPopulerLiveData: MutableLiveData<List<DataProducts>?>
        get() = _listPopulerLiveData

    private var _listTopLiveData: MutableLiveData<List<DataProducts>?> = MutableLiveData()
    val listTopLiveData: MutableLiveData<List<DataProducts>?>
        get() = _listTopLiveData

    private var _listPizzaLiveData: MutableLiveData<List<DataProducts>?> = MutableLiveData()
    val listPizzaLiveData: MutableLiveData<List<DataProducts>?>
        get() = _listPizzaLiveData

    private var _listAllMenuLiveData: MutableLiveData<List<DataProducts>?> = MutableLiveData()
    val listAllMenuLiveData: MutableLiveData<List<DataProducts>?>
        get() = _listAllMenuLiveData

    private var _listFoodLiveData: MutableLiveData<List<DataProducts>?> = MutableLiveData()
    val listFoodLiveData: MutableLiveData<List<DataProducts>?>
        get() = _listFoodLiveData

    private var _listDetailLiveData: MutableLiveData<Products?> = MutableLiveData()
    val listDetailLiveData: MutableLiveData<Products?>
        get() = _listDetailLiveData

    private var retrofit = RestClient.getRetrofit()
    private val endPointAPI = retrofit.create(HomeApi::class.java)

    fun getIntro(context: Context) {

        viewModelScope.launch(Dispatchers.IO) {
            val listIntro = mutableListOf<Intro>()
            val listTextAbove = listOf(
                R.string.deliicious_food,
                R.string.fast_delivery,
                R.string.certified_chef
            )
            val listTextBelow = listOf(
                R.string.cook_food_like_your_personel_cheft,
                R.string.cook_food_like_your_personel_cheft,
                R.string.cook_food_like_your_personel_cheft
            )

            for (i in listTextAbove.indices) {
                listIntro.add(
                    Intro(
                        context.getString(listTextAbove[i]),
                        context.getString(listTextBelow[i])
                    )
                )
            }
            _listIntroLiveData.postValue(listIntro)


        }
    }


    private fun getTokenFromSharedPreferences(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("myapp", Context.MODE_PRIVATE)
        return sharedPreferences.getString("token", null)
    }

    fun initDataPopuler(context: Context) {
        val token = getTokenFromSharedPreferences(context)
        val call = endPointAPI.getAllProducts("Bearer " + token)

        call.enqueue(object : Callback<HomeResponse> {
            override fun onResponse(
                call: Call<HomeResponse>?,
                response: Response<HomeResponse>?
            ) {
                val list = response?.body()?.data?.products
                if (list != null) {
                    _listPopulerLiveData.postValue(list)

                } else {
                    Toast.makeText(
                        context, "Username or password is incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<HomeResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun initDataTop(context: Context) {
        val token = getTokenFromSharedPreferences(context)
        val call = endPointAPI.getAllProducts("Bearer " + token)

        call.enqueue(object : Callback<HomeResponse> {
            override fun onResponse(
                call: Call<HomeResponse>?,
                response: Response<HomeResponse>?
            ) {
                val list = response?.body()?.data?.products
                if (list != null) {
                    _listTopLiveData.postValue(list)

                } else {
                    Toast.makeText(
                        context, "Username or password is incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<HomeResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun initDataFood(context: Context) {
        val token = getTokenFromSharedPreferences(context)
        val call = endPointAPI.getAllProducts("Bearer " + token)

        call.enqueue(object : Callback<HomeResponse> {
            override fun onResponse(
                call: Call<HomeResponse>?,
                response: Response<HomeResponse>?
            ) {
                val list = response?.body()?.data?.products
                if (list != null) {
                    _listFoodLiveData.postValue(list)

                } else {
                    Toast.makeText(
                        context, "Username or password is incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<HomeResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun initDataAllMenu(context: Context) {
        val token = getTokenFromSharedPreferences(context)
        val call = endPointAPI.getAllProducts("Bearer " + token)

        call.enqueue(object : Callback<HomeResponse> {
            override fun onResponse(
                call: Call<HomeResponse>?,
                response: Response<HomeResponse>?
            ) {
                val list = response?.body()?.data?.products
                if (list != null) {
                    _listAllMenuLiveData.postValue(list)

                } else {
                    Toast.makeText(
                        context, "Username or password is incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<HomeResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun initDataPizza(context: Context) {
        val token = getTokenFromSharedPreferences(context)
        val call = endPointAPI.getAllProducts("Bearer " + token)

        call.enqueue(object : Callback<HomeResponse> {
            override fun onResponse(
                call: Call<HomeResponse>?,
                response: Response<HomeResponse>?
            ) {
                val list = response?.body()?.data?.products
                if (list != null) {
                    _listPizzaLiveData.postValue(list)

                } else {
                    Toast.makeText(
                        context, "Username or password is incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<HomeResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun initDataSearch(context: Context) {
        val token = getTokenFromSharedPreferences(context)
        val call = endPointAPI.getAllProducts("Bearer " + token)
        call.enqueue(object : Callback<HomeResponse> {
            override fun onResponse(
                call: Call<HomeResponse>?,
                response: Response<HomeResponse>?
            ) {
                val list = response?.body()?.data?.products
                if (list != null) {
                    _listSearchLiveData.postValue(list)

                } else {
                    Toast.makeText(
                        context, "Username or password is incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<HomeResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun initDataBell(context: Context) {
        val token = getTokenFromSharedPreferences(context)
        val call = endPointAPI.getAllProducts("Bearer " + token)
        call.enqueue(object : Callback<HomeResponse> {
            override fun onResponse(
                call: Call<HomeResponse>?,
                response: Response<HomeResponse>?
            ) {
                val list = response?.body()?.data?.products
                if (list != null) {
                    _listBellLiveData.postValue(list)

                } else {
                    Toast.makeText(
                        context, "Username or password is incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<HomeResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }
    private val retrofitDetail = RestClient.getRetrofit()
    private val endPointDetailAPI = retrofitDetail.create(DetailApi::class.java)
    fun initDataDetail(context: Context,id :Int) {
        val token = getTokenFromSharedPreferences(context)
        val call = endPointDetailAPI.getDetail("Bearer " + token,id)
        call.enqueue(object : Callback<DetailFoodResponse> {
            override fun onResponse(
                call: Call<DetailFoodResponse>?,
                response: Response<DetailFoodResponse>?
            ) {
                val list = response?.body()?.data?.product
                if (list?.id== id) {
                    _listDetailLiveData.postValue(list)
                } else {
                    Toast.makeText(
                        context, "Username or password is incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<DetailFoodResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }
}
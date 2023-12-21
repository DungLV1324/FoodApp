package com.dunglv.foodapp.ui.homemain.home.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dunglv.foodapp.data.model.DataProducts
import com.dunglv.foodapp.ui.base.BaseViewModel

class ReSearchViewModel : BaseViewModel() {

    private var _listReSearchLiveData: MutableLiveData<MutableList<DataProducts>> = MutableLiveData()
    val listReSearchLiveData: LiveData<MutableList<DataProducts>>
        get() = _listReSearchLiveData


    fun filterList(text: String, data: MutableList<DataProducts>) {
        data.filter { it.name.uppercase().contains(text.uppercase()) }.let {
            _listReSearchLiveData.postValue(it.toMutableList())
        }
    }

    fun posNull() {
        _listReSearchLiveData.postValue(mutableListOf())
    }
}
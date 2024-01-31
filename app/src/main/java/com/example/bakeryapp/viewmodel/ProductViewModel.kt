package com.example.bakeryapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bakeryapp.dto.Product
import com.example.bakeryapp.model.FeedModel
import com.example.bakeryapp.repository.ProductRepository
import com.example.bakeryapp.repository.ProductsRepositoryImpl
import kotlin.concurrent.thread


class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository = ProductsRepositoryImpl()
    private val _state = MutableLiveData(FeedModel())
    val data: LiveData<FeedModel>
        get() = _state

    init {
        loadProducts()
    }

    fun loadProducts() {
        thread {
            _state.postValue(FeedModel(loading = true))
            try {
                val products = repository.getAllProducts()
                _state.postValue(products?.let { FeedModel(products = products, empty =  products.isEmpty()) })
            } catch (e: Exception) {
                _state.postValue(FeedModel(error = true))
            }
        }
    }
}
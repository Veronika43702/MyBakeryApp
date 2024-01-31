package com.example.bakeryapp.repository

import androidx.lifecycle.LiveData
import com.example.bakeryapp.dto.Product
import java.sql.ResultSet


interface ProductRepository {
    fun getAllProducts(): List<Product>?
    fun save(product: Product)
    fun remove(id: Long)
}
package com.example.bakeryapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.bakeryapp.entity.ProductEntity

@Dao
interface ProductDao {
    @Query("SELECT * FROM Products ORDER BY productName DESC")
    fun getALlProducts(): List<ProductEntity>
}
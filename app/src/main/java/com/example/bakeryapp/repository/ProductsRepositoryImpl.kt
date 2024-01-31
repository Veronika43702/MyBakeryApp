package com.example.bakeryapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.bakeryapp.dao.ProductDao
import com.example.bakeryapp.dto.Product
import com.example.bakeryapp.entity.ProductEntity
import com.example.bakeryapp.server.DBConnection


class ProductsRepositoryImpl() : ProductRepository {
    override fun getAllProducts(): List<Product> {
        val db = DBConnection().getDBConnection()
        if (db != null) {
            val table = DBConnection().querySelect(db, "SELECT id, name, price_per_unit FROM products")
            return if (table != null) {
                DBConnection().getListOfProducts(table)
            } else emptyList()
        } else return emptyList()
    }

    override fun save(product: Product) {
        TODO("Not yet implemented")
    }

    override fun remove(id: Long) {
        TODO("Not yet implemented")
    }
}
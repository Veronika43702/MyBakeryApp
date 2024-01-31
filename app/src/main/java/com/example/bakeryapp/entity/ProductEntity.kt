package com.example.bakeryapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bakeryapp.dto.Product

@Entity(tableName = "Products")
data class ProductEntity constructor(
    @PrimaryKey //(autoGenerate = true)
    val id: String,
    val productName: String,
    val pricePerUnit: Double,
){

    fun toDto(): Product = Product(
        id = id,
        productName = productName,
        price = pricePerUnit
    )

//    companion object{
//        fun fromDto(dto: Product): ProductEntity = with(dto){
//            ProductEntity(
//                id = id,
//                productName = productName,
//                pricePerUnit = price
//            )
//        }
//    }
}
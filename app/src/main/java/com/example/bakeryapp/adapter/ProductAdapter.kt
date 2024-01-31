package com.example.bakeryapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.bakeryapp.dto.Product

interface OnInteractionListener {
    fun getAllProducts(): List<Product>?
    fun save(product: Product)
    fun remove(id: Long)
}

class ProductAdapter (
    private val onInteractionListener: OnInteractionListener
) {}


class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }
}
package com.example.bakeryapp.repository

import com.example.bakeryapp.dto.Component


interface ComponentRepository {
    fun getAllComponents(): List<Component>?
    fun save(component: Component)
    fun remove(id: Long)
}
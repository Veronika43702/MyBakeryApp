package com.example.bakeryapp.repository

import com.example.bakeryapp.dto.Component
import com.example.bakeryapp.server.DBConnection


class ComponentRepositoryImpl() : ComponentRepository {
    override fun getAllComponents(): List<Component> {
        val db = DBConnection().getDBConnection()
        if (db != null) {
            val table = DBConnection().querySelect(db,
                "SELECT component_name, type, weight, price FROM components")
            return if (table != null) {
                DBConnection().getListOfComponents(table)
            } else emptyList()
        } else return emptyList()
    }


    override fun save(component: Component) {
        TODO("Not yet implemented")
    }


    override fun remove(id: Long) {
        TODO("Not yet implemented")
    }
}
package com.example.bakeryapp.server

import android.os.StrictMode
import com.example.bakeryapp.dto.Component
import com.example.bakeryapp.dto.Product
import com.example.bakeryapp.server.DBconstants.database
import com.example.bakeryapp.server.DBconstants.host
import com.example.bakeryapp.server.DBconstants.password
import com.example.bakeryapp.server.DBconstants.port
import com.example.bakeryapp.server.DBconstants.user

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement


class DBConnection(
) {
    fun getDBConnection(): Connection? {
        try {
            //Class.forName("org.postgresql.Driver")
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val db = DriverManager.getConnection(
                "jdbc:postgresql://$host:$port/$database",
                user,
                password
            )
            println("connection success")
            return db
        } catch (e: Exception) {
            println("connection failed")
            e.printStackTrace()
        }
        return null
    }

    fun getDBConnectionMain(): Connection? {
        try {
            //Class.forName("org.postgresql.Driver")
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val db = DriverManager.getConnection(
                "jdbc:postgresql://$host:$port/$database",
                user,
                password
            )
            println("connection success on main thread")
            return db
        } catch (e: Exception) {
            println("connection failed on main thread")
            e.printStackTrace()
        }
        return null
    }

    fun querySelect(db: Connection, query: String): ResultSet? {
        val statement: Statement
        var result: ResultSet? = null
        try {
            statement = db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)
            result = statement.executeQuery(query)
            return result

        } catch (e: Exception) {
            println(e.stackTrace);
        }
        return result
    }

    fun printTable(table: ResultSet) {
        val columns = table.getMetaData().getColumnCount()
        while (table.next()) {
            for (i in 1..columns) {
                print(table.getString(i) + "\t")
            }
            println()
        }
    }

    fun getListOfProducts(table: ResultSet): MutableList<Product> {
        val listOfProducts = mutableListOf<Product>()
        val columns = table.getMetaData().getColumnCount()
        while (table.next()) {
            val id = table.getString(1)
            val name = table.getString(2)
            val price = table.getString(3)
            val product = Product(id, name, price.toDouble())

            listOfProducts.add(product)
        }

        return listOfProducts
    }

    fun getListOfComponents(table: ResultSet): MutableList<Component> {
        val listOfComponent = mutableListOf<Component>()

        while (table.next()) {
            val name = table.getString(1)
            println(name)
            if (listOfComponent.find { it.name == name } == null) {
                val type = table.getString(2)
                var weight = table.getString(3).toDouble()
                var price = table.getString(4).toDouble()
                while (table.next()) {
                    if (table.getString(1) == name) {
                        println(table.getString(3))
                        weight += table.getString(3).toDouble()
                        price += table.getString(4).toDouble()

                    } else break
                }

                val component = Component(name, type, weight, price)
                println(component.toString())
                listOfComponent.add(component)
                table.previous()
            }
        }

        return listOfComponent
    }
}



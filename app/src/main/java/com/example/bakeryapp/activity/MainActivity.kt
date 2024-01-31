package com.example.bakeryapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bakeryapp.databinding.ActivityMainBinding
import com.example.bakeryapp.db.AppDb
import com.example.bakeryapp.server.DBConnection
import java.sql.ResultSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val data = AppDb.getDao(application).productDao.getALlProducts()
//        println("данные $data")

        //AppDb.createComponentsAppDB(application)

        //val repository:
//        val db = DBConnection().getDBConnectionMain()
//        val table: ResultSet?
//        if (db != null) {
//            table = DBConnection().querySelect(db, "SELECT name FROM products")
//            table?.let { DBConnection().printTable(it) }
//        } else println("база пуста")
    }
}
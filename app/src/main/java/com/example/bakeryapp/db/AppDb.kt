package com.example.bakeryapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bakeryapp.dao.ProductDao
import com.example.bakeryapp.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDb : RoomDatabase() {
    //abstract val productDao: ProductDao
    // TODO
    //abstract val componentsDao: ProductDao

    companion object {
        @Volatile
        private var instance: AppDb? = null

        fun getDao(context: Context): AppDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }


        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context, AppDb::class.java, "AppDataBase.db"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}
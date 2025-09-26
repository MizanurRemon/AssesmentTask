package com.technonext.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.technonext.database.dao.ProductsDao
import com.technonext.database.model.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 2,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract val productsDao: ProductsDao
}
package com.technonext.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val productID: Int = 0,
    val title: String?,
    val description: String?,
    val photoUrl: String?,
    @ColumnInfo(defaultValue = "false")
    val isFavorite: Boolean = false
)
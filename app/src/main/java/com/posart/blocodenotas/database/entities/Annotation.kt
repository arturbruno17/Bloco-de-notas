package com.posart.blocodenotas.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "annotations")
data class Annotation(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val content: String
)
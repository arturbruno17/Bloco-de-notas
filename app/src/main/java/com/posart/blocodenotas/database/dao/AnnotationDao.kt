package com.posart.blocodenotas.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import com.posart.blocodenotas.database.entities.Annotation

@Dao
interface AnnotationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnnotation(annotation: Annotation)

    @Update
    suspend fun updateAnnotation(annotation: Annotation)

    @Delete
    suspend fun deleteAnnotation(annotation: Annotation)

    @Query("SELECT * FROM annotations ORDER BY id ASC")
    fun readAllAnnotations(): LiveData<List<Annotation>>

}

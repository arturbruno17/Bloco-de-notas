package com.posart.blocodenotas.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import com.posart.blocodenotas.database.entities.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM annotations ORDER BY id ASC")
    fun readAllTasks(): LiveData<List<Task>>

}

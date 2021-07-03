package com.posart.blocodenotas.repositories

import androidx.lifecycle.LiveData
import com.posart.blocodenotas.database.dao.TaskDao
import com.posart.blocodenotas.database.entities.Task

class TaskRepository(private val taskDao: TaskDao) {

    val readAllData: LiveData<List<Task>> = taskDao.readAllTasks()

    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

}
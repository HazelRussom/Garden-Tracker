package com.gardentracker.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert
    fun addTask(task: Task)

    @Query("SELECT * FROM tasks ORDER BY id ASC")
    fun getAll(): LiveData<List<Task>>
}
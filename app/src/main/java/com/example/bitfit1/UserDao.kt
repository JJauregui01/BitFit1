package com.example.bitfit1

import  androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM data_of_user")
    fun getAll(): Flow<List<UserData>>

    @Insert
    fun insertAll(users: List<UserData>)

    @Insert
    fun insert(user: UserData)

//    @Query("DELETE FROM data_of_user")
//    fun deleteAll()


}
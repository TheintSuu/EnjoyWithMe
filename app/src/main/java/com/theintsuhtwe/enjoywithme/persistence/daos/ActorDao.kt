package com.theintsuhtwe.enjoywithme.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO


@Dao
interface ActorDao {

    @Query("SELECT * FROM actor")
    fun getAllActor(): LiveData<List<ActorVO>>

    @Query("SELECT * FROM actor WHERE id = :noteId")
    fun getActorById(noteId: Int) : LiveData<ActorVO>

    @Query("DELETE FROM actor")
    fun deleteAll()

    @Delete
    fun deleteActor(note: ActorVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActor(noteVO: ActorVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllActor(Actor: List<ActorVO>)
}
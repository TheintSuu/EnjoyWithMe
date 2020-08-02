package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.persistence.daos.MoviesDao
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.persistence.daos.ActorDao

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-02-14.
 */

@Database(entities = [MoviesVO::class, ActorVO::class], version = 7, exportSchema = false)
abstract class MoviesDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PADC_Movies_X.DB"
        var dbInstance: MoviesDB? = null

        fun getDBInstance(context: Context): MoviesDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MoviesDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun MoviesDao(): MoviesDao
    abstract fun ActorsDao(): ActorDao
}
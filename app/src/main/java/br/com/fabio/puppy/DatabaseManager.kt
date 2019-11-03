package br.com.fabio.puppy

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: PuppyDatabase
    init {
        val appContext = PuppyApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext,
            PuppyDatabase::class.java,
            "puppy.sqlite"
        ).build()
    }
    fun getAtividadeDAO(): AtividadeDAO {
        return dbInstance.atividadeDAO()
    }
}
package br.com.fabio.puppy

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Atividade::class), version = 1)
abstract class PuppyDatabase: RoomDatabase() {

    abstract fun atividadeDAO(): AtividadeDAO
}
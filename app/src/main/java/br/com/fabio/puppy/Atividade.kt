package br.com.fabio.puppy

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "atividade")
class Atividade : Serializable {

    @PrimaryKey
    var id:Long = 0
    var nome = ""
    var ementa = ""
    var foto = ""
    var professor = ""

    override fun toString(): String {
        return "Atividade(nome='$nome')"
    }
}

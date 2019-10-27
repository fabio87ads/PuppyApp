package br.com.fabio.puppy

import java.io.Serializable

class Atividade : Serializable {

    var id:Long = 0
    var nome = ""
    var ementa = ""
    var foto = ""
    var professor = ""

    override fun toString(): String {
        return "Atividade(nome='$nome')"
    }
}

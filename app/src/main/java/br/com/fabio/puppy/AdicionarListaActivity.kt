package br.com.fabio.puppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adicionar_lista.*

class AdicionarListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_lista)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ("Adicionar Passeio")

        botao_salvar.setOnClickListener {
            var d = Atividade()
            d.nome = campo_nome.text.toString()
            d.ementa = campo_ementa.text.toString()
            d.professor = campo_professor.text.toString()
            d.foto = campo_foto.text.toString()

            Thread {
                AtividadeService.save(d)
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}

package br.com.fabio.puppy

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.squareup.picasso.Picasso
import androidx.appcompat.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_atividade.*
import kotlinx.android.synthetic.main.toolbar.*

class AtividadeActivity : DebugActivity() {

    private val context: Context get() = this
    var atividade: Atividade? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade)

        // recuperar onjeto de Disciplina da Intent
        atividade = intent.getSerializableExtra("atividade") as Atividade

        // configurar título com nome da Disciplina e botão de voltar da Toobar
        // colocar toolbar
        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = atividade?.nome

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // atualizar dados da disciplina
        nomeAtividade.text = atividade?.nome
        Picasso.with(this).load(atividade?.foto).fit().into(imagemAtividade,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}

                override fun onError() { }
            })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_atividade, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId
        if  (id == R.id.action_deletar) {
            AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Deseja excluir a disciplina")
                .setPositiveButton("Sim") {
                        dialog, which ->
                    dialog.dismiss()
                    taskExcluir()
                }.setNegativeButton("Não") {
                        dialog, which -> dialog.dismiss()
                }.create().show()
        }
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun taskExcluir() {
        if (this.atividade != null && this.atividade is Atividade) {
            Thread {
                AtividadeService.delete(this.atividade as Atividade)
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }

}
package br.com.fabio.puppy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_tela_atividade.*

class TelaAtividadeActivity : AppCompatActivity() {

    private val context: Context get() = this
    private var atividades = listOf<Atividade>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_atividade)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ("Atividades")

        recyclerAtividades?.layoutManager = LinearLayoutManager(context)
        recyclerAtividades?.itemAnimator = DefaultItemAnimator()
        recyclerAtividades?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        taskAtividades()
    }

    fun taskAtividades() {
        Thread {
            this.atividades = AtividadeService.getAtividades(context)
            runOnUiThread {
                recyclerAtividades?.adapter = AtividadeAdapter(atividades) { onClickAtividade(it)
                }
            }
        }.start()
    }

    fun onClickAtividade(atividade: Atividade) {
        Toast.makeText(context, " ${atividade.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, AtividadeActivity::class.java)
        intent.putExtra("atividade", atividade)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_adicionar) {
            Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, AdicionarListaActivity::class.java)
            startActivity(intent)

        } else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
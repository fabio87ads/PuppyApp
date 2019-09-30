package br.com.fabio.puppy

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val nome = args?.getString("nome_usuario")
        val n = args?.getInt("numero")


        texto_tela_inicial.setText("Olá $nome")

        supportActionBar?.title = ("Cadastro")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou em buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_adicionar) {
            Toast.makeText(this, "Clicou em adicionar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_sair) {
            Toast.makeText(this, "Clicou em sair", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Clicou em sair", Toast.LENGTH_SHORT).show()
        }
        else if (id == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}

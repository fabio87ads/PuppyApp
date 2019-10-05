package br.com.fabio.puppy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        supportActionBar?.title = ("PUPPY")

        butao_1.setOnClickListener{ onClickBotao_1() }
        butao_2.setOnClickListener{ onClickBotao_2() }
        butao_3.setOnClickListener{ onClickBotao_3() }
    }

    private fun onClickBotao_1(){
        val intent = Intent(this, CadastroUsuarioActivity::class.java)
        startActivity(intent)
    }

    private fun onClickBotao_2(){
        val intent = Intent(this, CadastroPuppyActivity::class.java)
        startActivity(intent)
    }

    private fun onClickBotao_3(){
        val intent = Intent(this, SuporteActivity::class.java)
        startActivity(intent)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou em buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_adicionar) {
            Toast.makeText(this, "Clicou em adicionar", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, CadastroUsuarioActivity::class.java)
            startActivity(intent)

        } else if (id == R.id.action_sair) {
            Toast.makeText(this, "Clicou em sair", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Clicou em configuração", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, ConfiguracaoActivity::class.java)
            startActivity(intent)
        } else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}

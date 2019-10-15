package br.com.fabio.puppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro_usuario.*

class CadastroUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ("Cadastro Usuário")

        botao_Cadastrar_usuario.setOnClickListener { (onClickBotao_4())
        Toast.makeText(this, "Cadastros realizado com sucesso", Toast.LENGTH_SHORT).show()}
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun onClickBotao_4(){
        val intent = Intent(this, TelaInicialActivity::class.java)
        startActivity(intent)
    }
}



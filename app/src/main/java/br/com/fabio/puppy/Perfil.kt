package br.com.fabio.puppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_perfil.*

class Perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ("Perfil")

        botao_editar_usuario.setOnClickListener { (onClickBotao())
            Toast.makeText(this, "Editar Perfil", Toast.LENGTH_SHORT).show()}
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun onClickBotao(){
        val intent = Intent(this, CadastroUsuarioActivity::class.java)
        startActivity(intent)
    }
}
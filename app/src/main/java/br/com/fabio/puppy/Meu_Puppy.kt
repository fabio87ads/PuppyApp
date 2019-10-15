package br.com.fabio.puppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_meu__puppy.*
import kotlinx.android.synthetic.main.activity_perfil.*

class Meu_Puppy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meu__puppy)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ("Meu Puppy")

        botao_editar_puppy.setOnClickListener { (onClickBotao())
            Toast.makeText(this, "Meu Puppy", Toast.LENGTH_SHORT).show()}
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun onClickBotao(){
        val intent = Intent(this, CadastroPuppyActivity::class.java)
        startActivity(intent)
    }
}
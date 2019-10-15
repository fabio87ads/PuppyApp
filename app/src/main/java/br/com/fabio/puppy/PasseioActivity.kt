package br.com.fabio.puppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro_puppy.*
import kotlinx.android.synthetic.main.activity_passeio.*

class PasseioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passeio)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ("Passeios")

        image_mapa.setImageResource(R.drawable.mapa)

        botao_passear.setOnClickListener { (onClickBotao())
            Toast.makeText(this, "Bom passeio!", Toast.LENGTH_SHORT).show()}
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun onClickBotao(){
        val intent = Intent(this, TelaInicialActivity::class.java)
        startActivity(intent)
    }
}
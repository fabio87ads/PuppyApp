package br.com.fabio.puppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_suporte.*

class SuporteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suporte)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ("Suporte")

        botao_enviar_msn.setOnClickListener { (onClickBotao_6())
            Toast.makeText(this, "Mensagem enviada, aguarde o retorno", Toast.LENGTH_SHORT).show()}
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun onClickBotao_6(){
        val intent = Intent(this, TelaInicialActivity::class.java)
        startActivity(intent)
    }
}

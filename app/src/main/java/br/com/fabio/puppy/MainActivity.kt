package br.com.fabio.puppy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        dog_1.setImageResource(R.drawable.dog_inicial)

        val btLogin = findViewById(R.id.botao_login) as Button
        btLogin.setOnClickListener {
            val tLogin = findViewById(R.id.campo_usuario) as TextView
            val tSenha = findViewById(R.id.campo_senha) as TextView
            val login = tLogin.text.toString()
            val senha = tSenha.text.toString()
            if (login == "aluno" && senha == "impacta") {
                var intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
                alert("Login realizado com sucesso")
            } else {
                alert("Login ou senha incorretos")
            }
        }
    }
    private fun alert(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }
}

    /*fun onClickLogin(){
        var texto_usuario = campo_usuario.text.toString()
        Toast.makeText(this, "Olá, $texto_usuario",
            Toast.LENGTH_SHORT) .show()

        var intent = Intent(this, TelaInicialActivity::class.java)
        intent.putExtra("nome_usuario", texto_usuario)
        intent.putExtra("numero", 10)
        //var params = Bundle()
        //params.putString("nome_usuario", texto_usuario)
        //params.putInt("numero", 10)
        //intent.putExtras(params)
        startActivity(intent)
    }*/
    //botao_login.setOnClickListener{onClickLogin()

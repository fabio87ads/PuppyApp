package br.com.fabio.puppy

import android.os.Bundle
import com.squareup.picasso.Picasso
import androidx.appcompat.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_atividade.*
import kotlinx.android.synthetic.main.toolbar.*

class AtividadeActivity : DebugActivity() {

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

}
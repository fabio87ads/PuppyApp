package br.com.fabio.puppy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*


class TelaInicialActivity : DebugActivity(),
    NavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        dog_2.setImageResource(R.drawable.passeio_parque)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = ("PUPPY")

        butao_1.setOnClickListener{ onClickBotao_1() }
        butao_2.setOnClickListener{ onClickBotao_2() }
        butao_3.setOnClickListener{ onClickBotao_3() }

        configuraMenuLateral()
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
            Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_adicionar) {
            Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, CadastroPuppyActivity::class.java)
            startActivity(intent)

        } else if (id == R.id.action_sair) {
            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else if (id == R.id.action_notificacao) {
            Toast.makeText(this, "Notificação", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, NotificacaoActivity::class.java)
            startActivity(intent)
        } else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        /*val id = item.itemId
        if (id == R.id.nav_perfil){}*/
        when(item.itemId){
            R.id.nav_perfil ->{
                Toast.makeText(this,"Perfil", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, Perfil::class.java)
                startActivity(intent)
            }
            R.id.nav_puppy ->{
                Toast.makeText(this,"Puppy", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, Meu_Puppy::class.java)
                startActivity(intent)
            }
            R.id.nav_passeios ->{
                Toast.makeText(this,"Passeios", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, PasseioActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_atividades ->{
                Toast.makeText(this,"Atividades", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, TelaAtividadeActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_saude ->{
                Toast.makeText(this,"Saúde", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, SaudeActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_notificacao ->{
                Toast.makeText(this,"Notificações", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, NotificacaoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_suporte ->{
                Toast.makeText(this,"Suporte", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, SuporteActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_sair ->{
                Toast.makeText(this,"Sair", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }
    private fun configuraMenuLateral(){
        var toogle = ActionBarDrawerToggle(this, layoutMenuLateral, toolbar,
            R.string.open, R.string.close)
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }
}

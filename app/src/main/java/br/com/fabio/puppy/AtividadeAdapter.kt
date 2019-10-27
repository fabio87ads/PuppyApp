package br.com.fabio.puppy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AtividadeAdapter (
    val atividades: List<Atividade>,
    val onClick: (Atividade) -> Unit): RecyclerView.Adapter<AtividadeAdapter.AtividadesViewHolder>() {

        class AtividadesViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val cardNome: TextView
            val cardImg : ImageView
            var cardProgress: ProgressBar
            var cardView: CardView

            init {
                cardNome = view.findViewById<TextView>(R.id.cardNome)
                cardImg = view.findViewById<ImageView>(R.id.cardImg)
                cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
                cardView = view.findViewById<CardView>(R.id.card_atividades)

            }

        }
        override fun getItemCount() = this.atividades.size
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtividadesViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_atividade, parent, false)
            val holder = AtividadesViewHolder(view)
            return holder
        }
        override fun onBindViewHolder(holder: AtividadesViewHolder, position: Int) {
            val context = holder.itemView.context
            val atividade = atividades[position]

            holder.cardNome.text = atividade.nome
            holder.cardProgress.visibility = View.VISIBLE

            Picasso.with(context).load(atividade.foto).fit().into(holder.cardImg,
                object: com.squareup.picasso.Callback{
                    override fun onSuccess() {
                        holder.cardProgress.visibility = View.GONE
                    }
                    override fun onError() {
                        holder.cardProgress.visibility = View.GONE
                    }
                })
            holder.itemView.setOnClickListener {onClick(atividade)}
        }
    }
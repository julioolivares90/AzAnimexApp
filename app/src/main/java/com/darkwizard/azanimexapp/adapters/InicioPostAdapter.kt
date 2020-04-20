package com.darkwizard.azanimexapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.darkwizard.azanimexapp.R
import com.darkwizard.azanimexapp.models.InicioPost

class InicioPostAdapter (val animes : MutableList<InicioPost>) : RecyclerView.Adapter<InicioPostAdapter.IncioPostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncioPostHolder {
        
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.row_inicio_animes,parent,false)
        return IncioPostHolder(layoutInflater)
    }

    override fun getItemCount(): Int = animes.size

    override fun onBindViewHolder(holder: IncioPostHolder, position: Int) {
        val anime = animes[position]
        holder.bind(anime)
    }


    class IncioPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private  var title : TextView = itemView.findViewById(R.id.tv_title_inicio_anime)

        private  var imagen : ImageView = itemView.findViewById(R.id.iv_inicio_anime)
        fun bind(anime : InicioPost){

            title.text = anime.title
            Glide.with(itemView.context)
                .load(anime.image_post)
                .into(imagen)
        }
    }
}
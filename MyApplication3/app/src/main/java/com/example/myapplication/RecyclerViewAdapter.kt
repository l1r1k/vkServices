package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val context: Context, private val servicesList: ServicesArray): RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {



    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val iconService: ImageView = itemView.findViewById(R.id.photoService)
        val nameService: TextView = itemView.findViewById(R.id.nameService)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.service_card, parent, false)
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val arrayListItem = servicesList.getVkServices()[position]

        holder.itemView.setOnClickListener{ v->
            InfoService.positionService = position
            InfoService.arrayItem = servicesList.getVkServices()[position]
            val intent: Intent = Intent(v.context, InfoService::class.java)
            v.context.startActivity(intent)
        }
        Picasso.with(context).load(servicesList.getVkServices()[position].getIconService()).placeholder(R.drawable.download).error(R.drawable.error).into(holder.iconService)
        holder.nameService.text = servicesList.getVkServices()[position].getNameService()
    }

    override fun getItemCount() = servicesList.getVkServices().size

}
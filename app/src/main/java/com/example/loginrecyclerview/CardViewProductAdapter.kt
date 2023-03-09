package com.example.loginrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewProductAdapter(private val listProduct: ArrayList<Product>) : RecyclerView.Adapter<CardViewProductAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview_product, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val (name, desc, photo) = listProduct[position]


        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)


        holder.tvName.text = name
        holder.tvDesc.text = desc


        holder.btnFavorite.setOnClickListener { Toast.makeText(holder.itemView.context, "Like " + listProduct[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }


        holder.btnShare.setOnClickListener { Toast.makeText(holder.itemView.context, "Share " + listProduct[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }


        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, "Kamu memilih " + listProduct[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }

    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDesc: TextView = itemView.findViewById(R.id.tv_item_from)
        var btnFavorite: Button = itemView.findViewById(R.id.btnLike)
        var btnShare: Button = itemView.findViewById(R.id.btnShare)
    }
}

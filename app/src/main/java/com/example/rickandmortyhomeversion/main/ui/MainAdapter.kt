package com.example.rickandmortyhomeversion.main.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyhomeversion.R
import com.example.rickandmortyhomeversion.main.models.ResultParced
import timber.log.Timber

class MainAdapter(
    val onClick: (ResultParced) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val characters = mutableListOf<com.example.rickandmortyhomeversion.main.models.ResultParced>()

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.itemImageView)
        private val textView1: TextView = itemView.findViewById(R.id.itemTextView)
        private val textView2: TextView = itemView.findViewById(R.id.itemDescriptionTextView)

        fun bind(resultParced: ResultParced) {
            Glide.with(itemView.context).load(resultParced.image).placeholder(R.drawable.lanscape_placeholder).into(imageView)
            textView1.text = resultParced.name
            textView2.text = resultParced.id.toString()
            itemView.setOnClickListener { onClick.invoke(resultParced) }
        }

        fun detach() {
            Glide.with(itemView.context).clear(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val listItem = characters[position]
        holder.bind(listItem)
    }

    override fun onViewRecycled(holder: MainViewHolder) {
        super.onViewRecycled(holder)
        holder.detach()
    }

    override fun getItemCount() = characters.size

    fun setData(list: List<ResultParced>) {
        characters.clear()
        characters.addAll(list)
        Timber.i(list.toString())
        notifyDataSetChanged()
    }
}

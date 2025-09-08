package com.example.tarea1.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea1.R

class SimpleAdapter(
    private val data: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tv: TextView = v.findViewById(R.id.tvItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = data[position]
        holder.tv.text = item
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount(): Int = data.size
}

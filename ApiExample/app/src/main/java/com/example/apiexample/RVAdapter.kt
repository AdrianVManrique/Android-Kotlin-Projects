package com.example.apiexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val dataList: List<dataAPIItem>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.whateveryouwantto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        val item = dataList[position]
        holder.tvID.text = "ID: " + item.id.toString()
        holder.tvUSERID.text = "UserID: " + item.id.toString()
        holder.tvTITLE.text = "Title " + item.id.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvID: TextView = itemView.findViewById(R.id.tvid)
        val tvUSERID: TextView = itemView.findViewById(R.id.tvuserid)
        val tvTITLE: TextView = itemView.findViewById(R.id.tvtitle)
        init{
            itemView.setOnClickListener{
                Toast.makeText(itemView.context, "You have clicked ${ dataList[adapterPosition]}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
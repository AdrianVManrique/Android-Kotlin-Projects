package com.example.midterm_francis_adrian

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val postModel: MutableList<PostModel>, val onItemClicked:(position: Int) -> Unit):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.doc_entry, parent, false)
        return PostViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(postModel[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return postModel.size
    }
}

class PostViewHolder(itemView: View, val onItemClicked:(position: Int) -> Unit) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
    private val title: TextView = itemView.findViewById(R.id.eTitle)
    private val id: TextView = itemView.findViewById(R.id.eId)
    private val userId: TextView = itemView.findViewById(R.id.eUserId)
    private val completed: TextView = itemView.findViewById(R.id.eCompleted)

    fun bindView(postModel: PostModel, onItemClicked: (position: Int) -> Unit){
        title.text = postModel.title
        id.text = postModel.id
        userId.text = postModel.userId
        completed.text = postModel.completed.toString()
    }

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val position = adapterPosition
        onItemClicked(position)
    }
}
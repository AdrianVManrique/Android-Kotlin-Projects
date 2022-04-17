package com.example.midterm_francis_adrian

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore

class DisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_display, container, false)

        val displayButton = root.findViewById<Button>(R.id.button_display)
        val floatingButton = root.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val rView = root.findViewById<RecyclerView>(R.id.display_view)
        val db = FirebaseFirestore.getInstance()
        val midTermCol = db.collection("midterm")
        val list = mutableListOf<PostModel>()

        floatingButton.setOnClickListener() {
            val intent = Intent(context, UpdateActivity::class.java)
            startActivity(intent)
        }

        displayButton.setOnClickListener {
            midTermCol.get()
                .addOnSuccessListener { result ->
                    result.forEach {
                        //Log.d("Midterm Collection: ", it.data["id"].toString())
                        val entry = PostModel(it.data["userId"].toString(),
                                              it.data["id"].toString(),
                                              it.data["title"].toString(),
                                              it.data["completed"].toString().toBoolean())
                        list.add(entry)
                    }
                    Log.d("My MList: ", list.toString())
                    rView.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = PostAdapter(list){position ->  onListItemClick(position, rView)}
                    }

                }


        }
        return root
    }

    companion object {

        private const val MOVIE_GENRE = "MOVIE_TYPE"

        @JvmStatic

        fun newInstance(movieGenre: String) =
            DisplayFragment().apply {
                arguments = Bundle().apply {
                    putString(DisplayFragment.MOVIE_GENRE, movieGenre)
                }
            }
    }

    fun onListItemClick(position: Int, rView: RecyclerView){
        Log.d("Entry Position", position.toString())
        Log.d("Entry Info", rView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<TextView>(R.id.eUserId)?.text.toString())
        val entryTitle = rView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<TextView>(R.id.eTitle)?.text.toString()
        val entryUserId = rView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<TextView>(R.id.eUserId)?.text.toString()
        val entryID = rView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<TextView>(R.id.eId)?.text.toString()
        val entryCompleted = rView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<TextView>(R.id.eCompleted)?.text.toString()
        val intent = Intent(context, RemoveActivity::class.java)
        intent.putExtra("Title", entryTitle)
        intent.putExtra("UserID", entryUserId)
        intent.putExtra("ID", entryID)
        intent.putExtra("Completed", entryCompleted)
        startActivity(intent)
    }
}
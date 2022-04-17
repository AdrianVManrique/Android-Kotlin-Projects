package com.example.midterm_francis_adrian

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ApiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_api, container, false)
        val apiButton = root.findViewById<Button>(R.id.button_api_call)

        apiButton.setOnClickListener {
            Log.d("API CALL", "Success")
            val serviceGenerator = Placeholder.buildService(ApiService::class.java)
            val call = serviceGenerator.getPosts()


            Log.d("Before Enqeue","FAIL")

            call?.enqueue(object : Callback<MutableList<PostModel>> {
                override fun onResponse(
                    call: Call<MutableList<PostModel>>,
                    response: Response<MutableList<PostModel>>
                ) {
                    if(response.isSuccessful){
                        val db = FirebaseFirestore.getInstance()
                        val entry: MutableMap<String, Any> = HashMap()

                        Log.e("SuccessReq","Received Body")
                        response.body()?.forEach {

                        entry["userId"] = it.userId.toString()
                        entry["id"] = it.id.toString()
                        entry["title"] = it.title.toString()
                        entry["completed"] = it.completed.toString().toBoolean()

                        db.collection("midterm").document(it.title.toString())
                            .set(entry)
                            .addOnSuccessListener {
                                Log.d("db addEntry", "Success")
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("error",t.message.toString())
                }
            })


        }
        return root
    }

    companion object {

        private const val MOVIE_GENRE = "MOVIE_TYPE"

        @JvmStatic
        fun newInstance(movieGenre: String) =
            ApiFragment().apply {
                arguments = Bundle().apply {
                    putString(ApiFragment.MOVIE_GENRE, movieGenre)
                }
            }
    }
}
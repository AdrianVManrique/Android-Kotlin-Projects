package csusm.example.hw3_francis_adrian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore

class Signup : AppCompatActivity() {

    private lateinit var signup_storeEmail:TextInputEditText
    private lateinit var signup_storepassword:TextInputEditText
    private lateinit var signup_confirmpassword:TextInputEditText
    private lateinit var signup_storefullname:TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_signup)

        signup_storeEmail = findViewById(R.id.signup_storeEmail)
        signup_storepassword = findViewById(R.id.signup_storepassword)
        signup_confirmpassword = findViewById(R.id.signup_confirmpassword)
        signup_storefullname = findViewById(R.id.signup_storefullname)

    findViewById<Button>(R.id.signup_buttonsubmission).setOnClickListener() {
        //println("front test")
            val testEmail= signup_storeEmail.text.toString().trim()
            val testPassword= signup_storepassword.text.toString().trim()
            val testConfirmPassword= signup_confirmpassword.text.toString().trim()
            val testFullName= signup_storefullname.text.toString().trim()

        val email = findViewById<TextInputEditText>(R.id.signup_storeEmail).text.toString()
        val password = findViewById<TextInputEditText>(R.id.signup_storepassword).text.toString()
        val confirmpassword = findViewById<TextInputEditText>(R.id.signup_confirmpassword).text.toString()
        val fullName = findViewById<TextInputEditText>(R.id.signup_storefullname).text.toString()
        //println("before grabbing firebase instance")


       if (testEmail.isEmpty()){
           signup_storeEmail.error = "email required"
           return@setOnClickListener

       } else if(testPassword.isEmpty()){
            signup_storepassword.error = "password required"
           return@setOnClickListener
       }
        else if(testConfirmPassword.isEmpty()){
           signup_confirmpassword.error = "password required"
           return@setOnClickListener
       }
        else if(testFullName.isEmpty()){
            signup_storefullname.error = "full name required"
           return@setOnClickListener
       }
        else if(testPassword != testConfirmPassword){
            Toast.makeText(this, "Password is not the same", Toast.LENGTH_SHORT).show()
           return@setOnClickListener
       }
       else{
           Toast.makeText(this, "Registration Complete", Toast.LENGTH_SHORT).show()
           val db = FirebaseFirestore.getInstance()
           val user: MutableMap<String, Any> = HashMap()
           //println("assigning variables")
           user["Email"] = email
           user["FullName"] = fullName
           user["Password"] = password

           //println(fullName)
           //println(user["FullName"])

           println("variable collected ")
           db.collection("user")

               .add(user)
               .addOnSuccessListener {
                   Log.d("dbfirebase", "save: ${user}")
               }
               .addOnFailureListener {
                   Log.d("dbfirebase Failed", "${user}")
               }
           db.collection("user")
               .get()
               .addOnCompleteListener {
                   val result: StringBuffer = StringBuffer()

                   if (it.isSuccessful) {
                       //println("you in here")
                       for (document in it.result!!) {
                           //println("how about here?")
                           Log.d(
                               "dbfirebase", "retrieve: ${document.data.getValue("Email")} " +
                                       "${document.data.getValue("FullName")} " + "${document.data.getValue("Password")}")
                       }
                   }
               }

           val intent = Intent(this, MainActivity::class.java)
           startActivity(intent)
       }


        //println("end test")
     }
    }
}
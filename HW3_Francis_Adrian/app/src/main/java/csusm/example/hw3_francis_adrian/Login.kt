package csusm.example.hw3_francis_adrian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore

class Login : AppCompatActivity() {

    private lateinit var login_emailInput: TextInputEditText
    private lateinit var login_passwordInput: TextInputEditText
    private lateinit var login_fullNameInput:TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_emailInput = findViewById(R.id.login_emailInput)
        login_passwordInput = findViewById(R.id.login_passwordInput)
        //login_fullNameInput = findViewById(R.id.login_fullNameInput)

        findViewById<Button>(R.id.login_button).setOnClickListener(){

            val testEmail =  login_emailInput.text.toString().trim()
            val testPassword = login_passwordInput.text.toString().trim()
           // val testFullName = login_fullNameInput.text.toString().trim()

            if (testEmail.isEmpty()){
                login_emailInput.error = "email is required"
                return@setOnClickListener

            } else if(testPassword.isEmpty()){
                login_passwordInput.error = "password is required"
                return@setOnClickListener
            }
            else{

                val db = FirebaseFirestore.getInstance()
                //val userCollection = db.collection("users")

                val userCollection = db.collection("user")
                userCollection.whereEqualTo("Email", testEmail).get()
                    .addOnSuccessListener { task ->
                        if(task.count() > 0) {
                            val user = task.elementAt(0).data
                            if (user["Password"] == testPassword) {
                                //errorMessage.text = "Success"
                                val intent = Intent(this@Login, HelloCS481::class.java)
                                intent.putExtra("testFullName", user["FullName"].toString())
                                startActivity(intent)
                            } else {
                                login_passwordInput.error = "invalid password"
                            }
                        } else {
                            login_fullNameInput.error = "invalid user"
                        }
                    }


            }
            /* to be added later
            val intent = Intent(this, HelloCS481::class.java)
            startActivity(intent)
            */
        }

    }
}
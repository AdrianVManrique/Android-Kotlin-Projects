package csusm.example.hw3_francis_adrian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.main_button_login).setOnClickListener(){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.main_button_signup).setOnClickListener(){
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)

        }
    }
}
package csusm.example.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Grade : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        val gradeText = findViewById<TextView>(R.id.grade_gradeview)
        val gradeInput = findViewById<EditText>(R.id.grade_layout)

        findViewById<Button>(R.id.grade_showgradebutton).setOnClickListener(){

            val gradeIn = gradeInput.text.toString().toInt()

            if(gradeIn < 70) {
                gradeText.text = "F"

            }
            else if(gradeIn < 73 && gradeIn >= 70){
                println("this is the current input" + gradeIn)
                gradeText.text = "C-"
            }
            else if(gradeIn < 77 && gradeIn >= 73){
                gradeText.text = "C"
            }
            else if(gradeIn <  80 && gradeIn >= 77){
                gradeText.text = "C+"
            }
            else if(gradeIn < 83 && gradeIn >= 80){
                gradeText.text = "B-"
            }
            else if(gradeIn < 87 && gradeIn >= 83){
                gradeText.text = "B"
            }
            else if(gradeIn< 90 && gradeIn >= 87){
                gradeText.text = "B+"
            }
            else if(gradeIn < 94 && gradeIn >= 90){
                gradeText.text = "A-"
            }
            else if(gradeIn > 94){
                gradeText.text = "A"
            }
            else{
                gradeText.text = "you failed"
            }

        }

    }


}
package csusm.example.hw1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listInfo = findViewById<ListView>(R.id.main_listview)
        listInfo.adapter = MyCustomAdapter(this) //this needs to be the custom adapter telling my list what to render

        findViewById<Button>(R.id.main_gradebutton).setOnClickListener(){
            val intent = Intent(this, Grade::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.main_discountbutton).setOnClickListener(){
            val intent = Intent(this, DiscountActivity::class.java)
            startActivity(intent)

        }

    }

    private class MyCustomAdapter(context: Context): BaseAdapter(){
        private val studentInfo = arrayListOf<String>("Adrian Manrique","Arts","4th Year")
        private val mContext: Context

        init {
            this.mContext = context
        }
        //responsible for how many rows in my list
        override fun getCount(): Int {
            return 3;
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "test string"
        }

        //responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.main_row, viewGroup, false)

            val getInfoTextView = rowMain.findViewById<TextView>(R.id.info_textview)
            getInfoTextView.text = studentInfo.get(position)

            return rowMain;

        }
    }
}
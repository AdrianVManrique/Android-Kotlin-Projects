package csusm.example.hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.util.Log
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class DiscountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discount)


        findViewById<Button>(R.id.discount_getdiscountbutton).setOnClickListener() {
            findViewById<TextView>(R.id.discount_displaycoupon).text = "Enjoy your discount code below " + findViewById<TextInputEditText>(R.id.textInputEditText).text.toString() + " / " + findViewById<TextInputEditText>(R.id.textInputEditText2).text.toString()

            findViewById<TextView>(R.id.discount_couponcode).text = UUID.randomUUID().toString().take(8).toUpperCase()
        }
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")

        //Get the discount code or an empty string if it hasn't been set
        findViewById<TextView>(R.id.discount_couponcode).text = savedInstanceState.getString(DISCOUNT_CODE,"")
        //Get the discount confirmation message or an empty string if it hasn't been set
        findViewById<TextView>(R.id.discount_displaycoupon).text =
            savedInstanceState.getString(
                DISCOUNT_CONFIRMATION_MESSAGE,"")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")

        outState.putString(DISCOUNT_CODE,
            findViewById<TextView>(R.id.discount_couponcode).text.toString())
        outState.putString(DISCOUNT_CONFIRMATION_MESSAGE,
            findViewById<TextView>(R.id.discount_displaycoupon).text.toString())
    }

    companion object {
        private const val TAG = "MainActivity"
        private const val DISCOUNT_CONFIRMATION_MESSAGE = "DISCOUNT_CONFIRMATION_MESSAGE"
        private const val DISCOUNT_CODE = "DISCOUNT_CODE"
    }

}
package com.example.bieuthucbachai

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var res1: TextView
    lateinit var res2: TextView
    lateinit var a: EditText
    lateinit var b: EditText
    lateinit var c: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        res1 = findViewById(R.id.res1)
        res2 = findViewById(R.id.res2)
        a = findViewById(R.id.a)
        b = findViewById(R.id.b)
        c = findViewById(R.id.c)

        findViewById<Button>(R.id.button).setOnClickListener(this)
    }

    fun isNumber(text: String): Boolean {
        return text.toIntOrNull() != null || text.toDoubleOrNull() != null
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.button -> {
                var a_str = a.text.toString()
                var b_str = b.text.toString()
                var c_str = c.text.toString()

                if (isNumber(a_str) && isNumber(b_str) && isNumber(c_str)) {
                    var a_num = a_str.toDouble()
                    var b_num = b_str.toDouble()
                    var c_num = c_str.toDouble()

                    var delta: Double = b_num * b_num - 4 * a_num * c_num

                    if (delta < 0) {
                        res1.text = "No res"
                        res2.text = "No res"
                    }
                    else if (delta == 0.0) {
                        var res: Double = - (b_num / (2 * a_num))
                        res1.text = "x1=" + res.toString()
                        res2.text = "x2=" + res.toString()
                    }
                    else {
                        res1.text = "x1=" + ((- b_num + sqrt(delta)) / (2 * a_num)).toString()
                        res2.text = "x2=" + ((- b_num - sqrt(delta)) / (2 * a_num)).toString()
                    }
                }
                else {
                    res1.text = "Error"
                    res2.text = "Error"
                }


            }
        }
    }
}
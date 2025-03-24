package com.example.bieuthucbachai

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var res1: TextView
    lateinit var res2: TextView
    lateinit var a: EditText
    lateinit var b: EditText
    lateinit var c: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        // 1. Chuan bi du lieu
        val items = mutableListOf<String>()

        repeat(50) { items.add("Item $it")}


        // 2. Tao adapter
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            items
        )
        // layout tu thiet ke
//        val adapter = ArrayAdapter (    // adapter quy dinh cach hien thi du lieu danh sach
//            this,
//            R.layout.layout_simple_item,    // Chon file layout nao
//            R.id.text_content,  // Khai bao id cua textview de hien thi du lieu
//            items   // Doi tuong danh sach
//        )

        findViewById<Button>(R.id.Add).setOnClickListener {
            items.add(0, "New item")
            adapter.notifyDataSetChanged()
        }
        findViewById<Button>(R.id.Update).setOnClickListener {
            items[0] = "Update"
            adapter.notifyDataSetChanged()
        }
        findViewById<Button>(R.id.Remove).setOnClickListener {
            items.removeAt(0)
            adapter.notifyDataSetChanged()
        }
        // 3. Thiet lap adapter cho danh sach

        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter

        // 4. Xu ly su kien chon phan tu

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, "${items[position]}", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinner.setSelection(8)
    }

}
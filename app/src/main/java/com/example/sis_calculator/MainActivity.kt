package com.example.sis_calculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val  edt : EditText = findViewById(R.id.edit_text_id)
        val  edt1 : EditText = findViewById(R.id.edit_text_id1)
        val  edt2 : EditText = findViewById(R.id.edit_text_id2)
        val aver: TextView = findViewById(R.id.average)
        val cal: Button = findViewById(R.id.button1)
        val clear:Button = findViewById(R.id.button)
        val sis:Button = findViewById(R.id.button2)

        cal.setOnClickListener{
            val calculate:Double = edt.text.toString().toDouble()*0.25
            val calculate1:Double = edt1.text.toString().toDouble()* 0.3
            val calculate2:Double = edt2.text.toString().toDouble()*0.45

            Log.e("TAG", "onCreate: "+calculate)
            Log.d("TAG", "onCreate: "+calculate2 )
            Log.i("TAG", "onCreate: "+calculate1 )

            aver.setText(" " +(calculate +calculate1 +calculate2 ))


        }
        clear.setOnClickListener {
            edt.setText("")
            edt1.setText("")
            edt2.setText("")
        }




        val btn : Button = findViewById(R.id.button2)
        btn.setOnClickListener(){
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.sis.com"))
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return true } }
package com.example.myquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start: Button = findViewById(R.id.btn_start)
        val et_name: EditText = findViewById(R.id.et_name)

        btn_start.setOnClickListener {
            if (et_name.text.toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_SHORT)
                        .show()
            }else{
                val intent = Intent (this@MainActivity, QuizQuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}


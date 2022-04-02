package com.example.hw4

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.hw4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private var operation: String = ""
    private var operand: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.resultTextView)
    }

    public fun numberClick(view: View){
        if(view is Button){
            var result = resultText.text.toString()
            val number = view.text.toString()
            if(result=="0"){
                result = ""
            }
            val s = result + number
            resultText.text = s
        }
    }

    public fun operationClick(view: View){
        if(view is Button){
            operation = view.text.toString()
            operand = resultText.text.toString().toDouble()
            resultText.text = ""
        }
    }
    public fun equalsClick(view: View){
        val secondNumber = resultText.text.toString().toDouble()
        val k = when(operation){
            "+" -> operand + secondNumber
            "-" -> operand - secondNumber
            "*" -> operand * secondNumber
            "/" -> operand / secondNumber
            else -> {0}
        }
        resultText.text = k.toString()
    }

    public fun clearClick(view: View){
        if(view is Button){
            resultText.text = ""
        }
    }
}
package com.example.tasbeh

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasbeh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var sharedPreferences: SharedPreferences
    private var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("key", "value").apply()
        number = sharedPreferences.getInt("number", 0)
        binding.tv

        binding.btn.setOnClickListener {
            number++
            var editor = sharedPreferences.edit()
            editor.putInt("number",number)
            editor.apply()
            binding.tv.text = number.toString()

        }
    }
}
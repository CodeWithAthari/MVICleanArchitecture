package com.devatrii.mvicleanarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devatrii.mvicleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val activity = this
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCountIncrement.setOnClickListener {
            counter++
            binding.tvCounter.text = counter.toString()
        }

        binding.btnCountDecrement.setOnClickListener {
            counter--
            binding.tvCounter.text = counter.toString()
        }

    }
}




















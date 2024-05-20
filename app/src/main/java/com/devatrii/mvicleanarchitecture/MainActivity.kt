package com.devatrii.mvicleanarchitecture

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.devatrii.mvicleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val activity = this
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var counter = 0

    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(activity)[CounterViewModel::class.java]

        binding.btnCountIncrement.setOnClickListener {
            viewModel.onEvent(CounterEvents.Increment)
        }

        binding.btnCountDecrement.setOnClickListener {
            viewModel.onEvent(CounterEvents.Decrement)
        }

        val state = viewModel.state.asLiveData()

        state.observe(activity) { state ->
            val count = state.count
            val toastText = state.toastText

            if (toastText.isNotEmpty())
                Toast.makeText(activity,toastText,Toast.LENGTH_SHORT).show()


            binding.tvCounter.text = count.toString()
        }

    }
}




















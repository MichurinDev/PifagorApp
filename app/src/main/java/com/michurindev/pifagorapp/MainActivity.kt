package com.michurindev.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.michurindev.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultBtn.setOnClickListener {
            if (!isFieldEmpty()){
                binding.resultTextView.text = getResult(
                    binding.aEditText.text.toString().toDouble(),
                    binding.bEditText.text.toString().toDouble()
                )
            }
        }
    }
    private fun isFieldEmpty(): Boolean{
        binding.apply {
            if (aEditText.text.isNullOrEmpty()) aEditText.error =
                resources.getString(R.string.a_empty)
            if (bEditText.text.isNullOrEmpty()) aEditText.error =
                resources.getString(R.string.b_empty)
            return aEditText.text.isNullOrEmpty() || bEditText.text.isNullOrEmpty()
        }
    }

    private fun getResult(a: Double, b: Double): String{
        return "c = ${sqrt((a.pow(2.0) + b.pow(2.0)))}"
    }
}
package com.example.a5th_month_lesson_1

import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a5th_month_lesson_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContract {
    private val binding by lazy {
       ActivityMainBinding.inflate(layoutInflater)
    }

    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attachContract(this)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIncrement()
            }
            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
        }
    }

    override fun showResult(count: Int) = with(binding){
        tvCount.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        binding.tvCount.setTextColor(getColor(R.color.green))
    }

    override fun onDestroy() {
        presenter.detachContract()
        super.onDestroy()
    }
}
package com.hal_domae.pi12a_kadai04_05

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hal_domae.pi12a_kadai04_05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // クイズの正解
    private var rightAnswer: String? = null
    // 何問目か
    private var quizCount = 1
    private val quizData = mutableListOf(
        listOf("パンはパンでも食べられないパンは", "フライパン"),
        listOf("パンはパンでも食べられないパンは", "フライパン"),
        listOf("パンはパンでも食べられないパンは", "フライパン"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showNextQuiz()

    }

    // クイズを出題するメソッド
    private fun showNextQuiz(){
        // 問題番号を表示
        binding.countLabel.text = getString(R.string.count_label, quizCount)

        // クイズの問題をセット
        val quiz = quizData[0]
        binding.questionLabel.text = quiz[0]
    }

    fun checkQuizCount(){

    }
}
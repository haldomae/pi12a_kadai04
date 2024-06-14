package com.hal_domae.pi12a_kadai04_05

import android.os.Bundle
import android.view.KeyEvent
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
        binding.inputAnswer.setOnKeyListener { _, keyCode, event ->
            // event.action == KeyEvent.ACTION_DOWNはキーが押された時の処理
            // keyCode == KeyEvent.KEYCODE_ENTERはエンターキーが押された時の処理
            if(event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                checkAnswer()

                // trueを返すと他のキーイベントが発生しなくなる
                true
            } else {
                // falseを返すと返すと他のリスナーやシステムのキーイベント処理が続行される
                false
            }
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

    private fun checkAnswer(){
        // 入力された文字列の取得
        val answerText = binding.inputAnswer.text.toString()

        val alertTitle: String = "正解 or 不正解"

        // 各自で正解の場合は「正解」、不正解の場合は「不正解」にする

        val answerDialogFragment = AnswerDialogFragment()

        val bundle = Bundle().apply {
            putString("TITLE", alertTitle)
            putString("MESSAGE", "クイズの答え")
        }
        answerDialogFragment.arguments = bundle

        answerDialogFragment.isCancelable = false

        answerDialogFragment.show(supportFragmentManager, "my_dialog")
    }
}
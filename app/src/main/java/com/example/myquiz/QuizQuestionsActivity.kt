package com.example.myquiz

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    // Когда активити стартует, мы на первом вопросе
    private var mCurrentPosition:Int = 1

    // Изначально mQuestionsList это null
    private var mQuestionsList: ArrayList<Question>? = null

    private var mSelectedOptionPosition: Int = 0 // Позиция выбранного ответа

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuetions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

    }

    // Инициализируем переменные
    val tv_option_one: TextView = findViewById(R.id.tv_option_one)
    val tv_option_two: TextView = findViewById(R.id.tv_option_two)
    val tv_option_three: TextView = findViewById(R.id.tv_option_three)
    val tv_option_four: TextView = findViewById(R.id.tv_option_four)


    private fun setQuestion() {

        // Текущая позиция = какой вопрос
        mCurrentPosition = 1
        val question = mQuestionsList!!.get(mCurrentPosition-1)

        defaultOptionsView() // Устанавливаем опции по умолчанию на каждом новом вопросе

        // Прогресс бар
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        progressBar.progress = mCurrentPosition

        val tv_progress: TextView = findViewById(R.id.tv_progress)
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        // Текст вопроса и картинка
        val tv_question: TextView = findViewById(R.id.tv_question)
        tv_question.text = question!!.question

        val iv_image: ImageView = findViewById(R.id.iv_image)
        iv_image.setImageResource(question.image)

        // 4 ответа
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    // Устанавливаем первоначальные визуальные настройки для 4 ответов (шрифт, цвет, бэкграунд)
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(0, tv_option_two)
        options.add(0, tv_option_three)
        options.add(0, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {

    }

}
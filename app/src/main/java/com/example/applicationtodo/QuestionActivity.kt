package com.example.applicationtodo

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    private var score:Int=0
    private var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData>?=null
    private var selectedOption:Int=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        SetData.getQuestion()

         questionList = SetData.getQuestion()
        setQuestion()
        fun setColor(opt:Int,color:Int){
            when(opt){
                1->{
                    option1.background=ContextCompat.getDrawable(this,color)
                }
                2->{
                    option2.background=ContextCompat.getDrawable(this,color)
                }
                3->{
                    option3.background=ContextCompat.getDrawable(this,color)
                }
                4->{
                    option4.background=ContextCompat.getDrawable(this,color)
                }
            }
        }
        fun answerCheck(opt:Int){
            if (selectedOption!=0){
                val quiz = questionList!![currentPosition-1]
                if(selectedOption!=quiz.correct_ans){
                    setColor(selectedOption,R.drawable.wrong_option)
                }else{
                    score++
                }
                setColor(quiz.correct_ans,R.drawable.correct_options)
                if (currentPosition!=questionList!!.size){
                    setOptionStyle()
                    selectedOption=opt
                    score++
                    currentPosition++
                    setQuestion()
                }else{
                    var intent= Intent(this,ResultActivity::class.java)
                    intent.putExtra(SetData.score,score.toString())
                    startActivity(intent)
                }
            }

        }

        option1.setOnClickListener{
            answerCheck(opt = 1)
        }
        option2.setOnClickListener{
            answerCheck(opt = 2)
        }
        option3.setOnClickListener{
            answerCheck(opt = 3)
        }
        option4.setOnClickListener{
            answerCheck(opt = 4)
        }

    }
    private fun setQuestion(){
        val quiz = questionList!![currentPosition-1]
        setOptionStyle()
        questionId.text=quiz.question
        option1.text=quiz.option_one
        option2.text=quiz.option_two
        option3.text=quiz.option_three
        option4.text=quiz.option_four
    }
    private fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,option1)
        optionList.add(1,option2)
        optionList.add(2,option3)
        optionList.add(3,option4)
        for(op in optionList){
           op.setTextColor(Color.LTGRAY)
            op.background=ContextCompat.getDrawable(this,R.drawable.question_options)
            op.typeface= Typeface.DEFAULT
        }
    }
}
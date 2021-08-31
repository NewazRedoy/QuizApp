package com.example.applicationtodo

object SetData {
  fun getQuestion(): ArrayList<QuestionData> {
val que:ArrayList<QuestionData> = arrayListOf()
      val q1=QuestionData(
          question = "What is the color of a ripe banana?",
          id = 1,
          option_one = "Red",
          option_two = "Blue",
          option_three = "Teal",
          option_four = "Yellow",
          correct_ans = 4
      )
      val q2=QuestionData(
          question = "What is the color of Ocean?",
          id = 1,
          option_one = "Red",
          option_two = "Blue",
          option_three = "Green",
          option_four = "Yellow",
          correct_ans = 2
      )
      val q3=QuestionData(
          question = "What is the color of a Bee?",
          id = 1,
          option_one = "Red",
          option_two = "Blue",
          option_three = "Teal",
          option_four = "Yellow",
          correct_ans = 4
      )
      val q4=QuestionData(
          question = "What is the color of sky?",
          id = 1,
          option_one = "Red",
          option_two = "Blue",
          option_three = "Teal",
          option_four = "Yellow",
          correct_ans = 2
      )
      val q5=QuestionData(
          question = "Who many colors the rainbow have?",
          id = 1,
          option_one = "3",
          option_two = "5",
          option_three = "12",
          option_four = "7",
          correct_ans = 4
      )
      que.add(q1)
      que.add(q2)
      que.add(q3)
      que.add(q4)
      que.add(q5)
      return que
  }
}
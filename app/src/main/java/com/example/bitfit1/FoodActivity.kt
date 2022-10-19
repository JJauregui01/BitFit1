package com.example.bitfit1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FoodActivity : AppCompatActivity() {

    lateinit var recordFood: Button
    lateinit var userFood: EditText
    lateinit var userCalories: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        recordFood = findViewById(R.id.addFoodData)
        userFood = findViewById((R.id.foodInput))
        userCalories = findViewById(R.id.calorieInput)


        recordFood.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("food", UserClass(userFood.text.toString(), userCalories.text.toString()))

            this.startActivity(intent)



        }
    }
}
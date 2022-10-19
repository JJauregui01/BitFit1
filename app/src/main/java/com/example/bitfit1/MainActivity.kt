package com.example.bitfit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val foodz = mutableListOf<UserClass>()
    lateinit var addFoodButton: Button
    lateinit var foodListRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFoodButton = findViewById(R.id.addFood)
        val adapter = BitFitAdapter(this, foodz)

        foodListRv = findViewById(R.id.recycleDisplay)
        foodListRv.adapter = adapter
        foodListRv.layoutManager = LinearLayoutManager(this)

        val foodData = intent.getSerializableExtra("food") as UserClass?
        lifecycleScope.launch {
            (application as DaoApplication).db.UserDao().getAll().collect { dataBaseList ->
                dataBaseList.map { entity ->
                    UserClass(
                        entity.food,
                        entity.calories
                    )
                }.also { mList ->
                    foodz.clear()
                    foodz.addAll(mList)
                    adapter.notifyDataSetChanged()
                }
            }
        }


        if (foodData != null){
            lifecycleScope.launch(IO){
                (application as DaoApplication).db.UserDao().insert(
                    UserData(
                        food = foodData.foods,
                        calories = foodData.calories
                    )
                )
            }
        }
        else{
            Log.d("MainActivity", "no extra")
        }


        addFoodButton.setOnClickListener{
            val intent = Intent(this, FoodActivity::class.java)

            this.startActivity(intent)
        }
    }
}

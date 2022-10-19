package com.example.bitfit1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BitFitAdapter(private val context: Context, private val foods: MutableList<UserClass>):
RecyclerView.Adapter<BitFitAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var foodName: TextView = itemView.findViewById(R.id.showFood)
        var numberOfCalories: TextView = itemView.findViewById(R.id.calorieNum)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)

        val contractView = inflater.inflate(R.layout.activity_detail, parent, false)
        return ViewHolder(contractView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foods[position]

        holder.foodName.text = food.foods
        holder.numberOfCalories.text = food.calories
    }

    override fun getItemCount(): Int {
        return foods.size
    }
}

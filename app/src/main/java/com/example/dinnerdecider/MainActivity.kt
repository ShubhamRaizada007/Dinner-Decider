package com.example.dinnerdecider

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val foodList = mutableListOf("Pizza", "Burger", "Pasta", "Salad", "Sushi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodText: TextView = findViewById(R.id.selectedFoodTxt)
        val addFoodEdit: EditText = findViewById(R.id.addFoodTxt)
        val addFoodBtn: Button = findViewById(R.id.addFoodButton)
        val decideBtn: Button = findViewById(R.id.decideButton)

        decideBtn.setOnClickListener {
            val randomFood = foodList[Random.nextInt(foodList.size)]
            foodText.text = randomFood
        }

        addFoodBtn.setOnClickListener {
            val newFood = addFoodEdit.text.toString()
            if (newFood.isNotBlank()) {
                foodList.add(newFood)
                Toast.makeText(this, "$newFood added!", Toast.LENGTH_SHORT).show()
                addFoodEdit.text.clear()
            }
        }

        foodText.setOnClickListener {
            foodList.clear()
            Toast.makeText(this, "Food list cleared!", Toast.LENGTH_SHORT).show()
            foodText.text = ""
        }
    }
}

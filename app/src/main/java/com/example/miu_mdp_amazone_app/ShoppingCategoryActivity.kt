package com.example.miu_mdp_amazone_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.miu_mdp_amazone_app.ui.theme.ui.theme.MiumdpamazoneappTheme

class ShoppingCategoryActivity : ComponentActivity() {
    private lateinit var btnToys: ImageButton
    private lateinit var btnBeauty: ImageButton
    private lateinit var btnPetFood: ImageButton
    private lateinit var btnHomeKitchen: ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        btnToys = findViewById(R.id.btnToys)
        btnBeauty = findViewById(R.id.btnBeauty)
        btnHomeKitchen = findViewById(R.id.btnHomeKitchen)
        btnPetFood = findViewById(R.id.btnPetFood)

        btnToys.setOnClickListener{
            Toast.makeText(this, "Toys and games", Toast.LENGTH_LONG).show()
        }
        btnBeauty.setOnClickListener{
            Toast.makeText(this, "Beauty and personal care", Toast.LENGTH_LONG).show()
        }
        btnPetFood.setOnClickListener{
            Toast.makeText(this, "Pet supplies", Toast.LENGTH_LONG).show()
        }
        btnHomeKitchen.setOnClickListener{
            Toast.makeText(this, "Home and Kitchen", Toast.LENGTH_LONG).show()
        }
    }
}
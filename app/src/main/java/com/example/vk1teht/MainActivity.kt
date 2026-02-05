package com.example.vk1teht

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vk1teht.ui.theme.Vk1tehtTheme
import com.example.vk1teht.View.HomeScreen
import com.example.vk1teht.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vk1tehtTheme {
                Navigation()
            }
        }
    }
}



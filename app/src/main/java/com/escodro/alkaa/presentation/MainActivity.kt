package com.escodro.alkaa.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.escodro.alkaa.navigation.NavGraph
import com.escodro.designsystem.AlkaaTheme
import com.escodro.designsystem.rememberWindowSizeClass

/**
 * Main Alkaa Activity.
 */
internal class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val windowSize = rememberWindowSizeClass()
            AlkaaTheme {
                NavGraph(windowSize)
            }
        }
    }
}

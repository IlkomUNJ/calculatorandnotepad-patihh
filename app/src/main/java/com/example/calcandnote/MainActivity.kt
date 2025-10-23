package com.example.calcandnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calcandnote.ui.theme.CalcAndNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcAndNoteTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(
            navController = navController,
            startDestination = "menu"
        ) {
            composable("menu") {
                MenuScreen(
                    onNavigateToCalculator = {
                        navController.navigate("calculator")
                    },
                    onNavigateToNotepad = {
                        navController.navigate("notepad")
                    }
                )
            }

            composable("calculator") {
                CalculatorScreen.SetupLayout(onBack = { navController.popBackStack() })
            }

            composable("notepad") {
                NotepadScreen(onBack = { navController.popBackStack() })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
    CalcAndNoteTheme {
        MainApp()
    }
}

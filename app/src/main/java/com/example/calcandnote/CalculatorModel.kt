package com.example.calcandnote

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CalculatorModel(
    var displayText: String = "0",
    var firstNumber: String = "",
    var operator: String = "",
    var secondNumber: String = "",
    var isScientific: MutableState<Boolean> = mutableStateOf(false)
)
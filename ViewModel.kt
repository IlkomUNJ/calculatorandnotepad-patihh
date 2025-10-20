package com.example.basicscodelab

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.math.acos
import kotlin.math.asin
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

class CalculatorViewModel : ViewModel() {

    var model = CalculatorModel()
    var displayText = mutableStateOf("0")

    private fun updateDisplay() {
        displayText.value = buildString {
            append(
                model.
                firstNumber.
                ifEmpty { "0" }
            )
            if (model.operator.isNotEmpty()) {
                append(" ${model.operator}")
                if (model.secondNumber.isNotEmpty()) {
                    append(" ${model.secondNumber}")
                }
            }
        }
    }

    fun onNumberClick(num: String) {
        if (model.operator.isEmpty()) {
            model.firstNumber = if (model.firstNumber == "0") num else model.firstNumber + num
        } else {
            model.secondNumber = if (model.secondNumber == "0") num else model.secondNumber + num
        }
        updateDisplay()
    }

    fun onDotClick() {
        if (model.operator.isEmpty()) {
            if (!model.firstNumber.contains(".")) {
                model.firstNumber = if (model.firstNumber.isEmpty()) "0." else "${model.firstNumber}."
            }
        } else {
            if (!model.secondNumber.contains(".")) {
                model.secondNumber = if (model.secondNumber.isEmpty()) "0." else "${model.secondNumber}."
            }
        }
        updateDisplay()
    }

    fun onOperatorClick(op: String) {
        if (model.firstNumber.isNotEmpty()) {
            model.operator = op
            updateDisplay()
        }
    }

    fun onBackspace() {
        when {
            model.secondNumber.isNotEmpty() -> model.secondNumber = model.secondNumber.dropLast(1)
            model.operator.isNotEmpty() -> model.operator = ""
            model.firstNumber.isNotEmpty() -> {
                model.firstNumber = model.firstNumber.dropLast(1)
                if (model.firstNumber.isEmpty()) model.firstNumber = "0"
            }
        }
        updateDisplay()
    }

    fun onClear() {
        model = CalculatorModel()
        displayText.value = "0"
    }

    fun onEqual() {
        if (model.firstNumber.isNotEmpty() && model.operator.isNotEmpty() && model.secondNumber.isNotEmpty()) {
            val num1 = model.firstNumber.toDouble()
            val num2 = model.secondNumber.toDouble()
            val result = when (model.operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "x" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                "%" -> num1 % num2
                "^" -> num1.pow(num2)
                else -> 0.0
            }
            model.firstNumber = if (result % 1 == 0.0) result.toInt().toString() else result.toString()
            model.operator = ""
            model.secondNumber = ""
            displayText.value = model.firstNumber
        }
    }

    fun factorial(n: Double): Double {
        val intN = n.toInt()
        return if (n < 0 || n % 1 != 0.0) Double.NaN
        else if (intN == 0 || intN == 1) 1.0
        else (2..intN).fold(1.0) { acc, i -> acc * i }
    }

    fun onScientificFunction(func: String) {
        if (model.firstNumber.isEmpty()) return
        val num = model.firstNumber.toDouble()
        val result = when (func) {
            "1/x" -> if (num != 0.0) 1 / num else Double.NaN
            "x!" -> factorial(num)
            "√x" -> sqrt(num)
            "sin" -> sin(Math.toRadians(num))
            "cos" -> cos(Math.toRadians(num))
            "tan" -> tan(Math.toRadians(num))
            "arcsin" -> Math.toDegrees(asin(num))
            "arccos" -> Math.toDegrees(acos(num))
            "arctan" -> Math.toDegrees(atan(num))
            "log" -> log10(num)
            "ln" -> ln(num)
            else -> num
        }
        model.firstNumber = if (result % 1 == 0.0) result.toInt().toString() else result.toString()
        model.operator = ""
        model.secondNumber = ""
        displayText.value = model.firstNumber
    }

    fun toggleScientific() {
        model.isScientific.value = !model.isScientific.value
    }
}
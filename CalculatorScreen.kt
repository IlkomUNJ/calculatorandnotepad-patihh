package com.example.basicscodelab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

object CalculatorScreen {
    @Composable
    fun SetupLayout(
        modifier: Modifier = Modifier,
        viewModel: CalculatorViewModel = viewModel(),
        onBack: (() -> Unit)? = null
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            val displayText by viewModel.displayText
            val isScientific by viewModel.model.isScientific

            Surface(
                color = Color.White,
                modifier = modifier.padding(10.dp)
            ) {
                Column {
                    CalculatorTextResult(
                        text = displayText,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Column(
                        modifier = Modifier
                            .border(
                                width = 2.dp,
                                color = Color.Black
                            )
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (!isScientific) {
                            Row {
                                CalculatorButton(
                                    "AC",
                                    onClick = { viewModel.onClear() },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "<-",
                                    onClick = { viewModel.onBackspace() },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "%",
                                    onClick = { viewModel.onOperatorClick("%") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "/",
                                    onClick = { viewModel.onOperatorClick("/") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                            }
                            Row {
                                CalculatorButton(
                                    "7",
                                    onClick = { viewModel.onNumberClick("7") }
                                )
                                CalculatorButton(
                                    "8",
                                    onClick = { viewModel.onNumberClick("8") }
                                )
                                CalculatorButton(
                                    "9",
                                    onClick = { viewModel.onNumberClick("9") }
                                )
                                CalculatorButton(
                                    "x",
                                    onClick = { viewModel.onOperatorClick("x") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                            }
                            Row {
                                CalculatorButton(
                                    "4",
                                    onClick = { viewModel.onNumberClick("4") }
                                )
                                CalculatorButton(
                                    "5",
                                    onClick = { viewModel.onNumberClick("5") }
                                )
                                CalculatorButton(
                                    "6",
                                    onClick = { viewModel.onNumberClick("6") }
                                )
                                CalculatorButton(
                                    "-",
                                    onClick = { viewModel.onOperatorClick("-") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                            }
                            Row {
                                CalculatorButton(
                                    "1",
                                    onClick = { viewModel.onNumberClick("1") }
                                )
                                CalculatorButton(
                                    "2",
                                    onClick = { viewModel.onNumberClick("2") }
                                )
                                CalculatorButton(
                                    "3",
                                    onClick = { viewModel.onNumberClick("3") }
                                )
                                CalculatorButton(
                                    "+",
                                    onClick = { viewModel.onOperatorClick("+") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                            }
                            Row {
                                CalculatorButton(
                                    ".",
                                    onClick = { viewModel.onDotClick() }
                                )
                                CalculatorButton(
                                    "0",
                                    onClick = { viewModel.onNumberClick("0") }
                                )
                                CalculatorButton(
                                    "=",
                                    onClick = { viewModel.onEqual() },
                                    containerColor = Color(0xFFFEA72E),
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "sci",
                                    onClick = { viewModel.toggleScientific() },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                            }
                        } else {
                            // Scientific layout
                            Row {
                                CalculatorButton(
                                    "1/x",
                                    onClick = { viewModel.onScientificFunction("1/x") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "x!",
                                    onClick = { viewModel.onScientificFunction("x!") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "xʸ",
                                    onClick = { viewModel.onOperatorClick("^") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "√x",
                                    onClick = { viewModel.onScientificFunction("√x") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                            }
                            Row {
                                CalculatorButton(
                                    "sin",
                                    onClick = { viewModel.onScientificFunction("sin") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "cos",
                                    onClick = { viewModel.onScientificFunction("cos") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "tan",
                                    onClick = { viewModel.onScientificFunction("tan") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "AC",
                                    onClick = { viewModel.onClear() },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                            }
                            Row {
                                CalculatorButton(
                                    "arcsin",
                                    onClick = { viewModel.onScientificFunction("arcsin") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "arccos",
                                    onClick = { viewModel.onScientificFunction("arccos") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "arctan",
                                    onClick = { viewModel.onScientificFunction("arctan") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "<-",
                                    onClick = { viewModel.onBackspace() },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                            }
                            Row {
                                CalculatorButton(
                                    "log",
                                    onClick = { viewModel.onScientificFunction("log") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "ln",
                                    onClick = { viewModel.onScientificFunction("ln") },
                                    containerColor = Color.Gray,
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "=",
                                    onClick = { viewModel.onEqual() },
                                    containerColor = Color(0xFFFEA72E),
                                    textColor = Color.White
                                )
                                CalculatorButton(
                                    "std",
                                    onClick = { viewModel.toggleScientific() }
                                )
                            }
                        }
                    }
                    onBack?.let {
                        Button(onClick = it, modifier = Modifier.padding(8.dp)) {
                            Text("Back to Menu")
                        }
                    }
                }
            }

        }
    }

    @Composable
    fun CalculatorButton(
        text: String,
        modifier: Modifier = Modifier,
        onClick: () -> Unit = {},
        containerColor: Color = Color.White,
        textColor: Color = Color.Black
    ) {
        ElevatedButton(
            onClick = onClick,
            modifier = modifier
                .padding(8.dp)
                .height(50.dp)
                .width(70.dp),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(1.dp, Color.Black),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor,
                contentColor = textColor
            )
        ) {
            Text(text = text, fontSize = 18.sp)
        }
    }

    @Composable
    fun CalculatorTextResult(text: String, modifier: Modifier = Modifier) {
        val scrollState = rememberScrollState()
        LaunchedEffect(text) { scrollState.scrollTo(scrollState.maxValue) }

        Surface(
            color = Color.White,
            border = BorderStroke(2.dp, Color.Black),
            modifier = modifier
                .height(80.dp)
                .padding(bottom = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
                    .horizontalScroll(scrollState),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = text,
                    fontSize = 28.sp,
                    color = Color.Black,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    BasicsCodelabTheme {
        CalculatorScreen.SetupLayout()
    }
}
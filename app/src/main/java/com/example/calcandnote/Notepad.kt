package com.example.calcandnote

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calcandnote.ui.theme.CalcAndNoteTheme

@Composable
fun NotepadScreen(onBack: (() -> Unit)? = null) {
    var text by remember { mutableStateOf("") }
    var fontSize by remember { mutableFloatStateOf(18f) }
    var fontWeight by remember { mutableStateOf(FontWeight.Normal) }
    var fontStyle by remember { mutableStateOf(FontStyle.Normal) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 5.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(5.dp)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    modifier = Modifier.width(100.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { fontWeight = FontWeight.Bold },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                ) {
                    Text("Bold")
                }
                Button(
                    modifier = Modifier.width(100.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { fontStyle = FontStyle.Italic },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                ) {
                    Text("Italic")
                }
                Button(
                    modifier = Modifier.width(100.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = {
                    fontWeight = FontWeight.Normal
                    fontStyle = FontStyle.Normal
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                ) {
                    Text("Normal")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    modifier = Modifier.width(100.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { if (fontSize < 40f) fontSize += 2 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                ) {
                    Text("A+")
                }
                Button(
                    modifier = Modifier.width(100.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { if (fontSize > 10f) fontSize -= 2 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                ) {
                    Text("A-")
                }
            }
        }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(
                "Notes",
                color = Color.Black
            ) },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            textStyle = TextStyle(
                fontSize = fontSize.sp,
                fontWeight = fontWeight,
                fontStyle = fontStyle,
                color = Color.Black
            ),
            minLines = 10,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFFF59D),
                unfocusedContainerColor = Color(0xFFFFF59D),
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.DarkGray
            )
        )
        onBack?.let {
            Button(onClick = it, modifier = Modifier.padding(8.dp)) {
                Text("Back to Menu")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotepadPreview() {
    CalcAndNoteTheme {
        NotepadScreen()
    }
}
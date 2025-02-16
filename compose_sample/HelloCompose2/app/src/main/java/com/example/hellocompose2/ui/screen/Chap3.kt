package com.example.hellocompose2.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.hellocompose2.R

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertSample() {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Cancel")
            }
        },
        icon = {
            Icon(painter = painterResource(id = R.drawable.info), contentDescription = "")
        },
        title = { Text(text = "Sample Dialog") },
        text = { Text(text = "This is a compose sample dialog.") },
        containerColor = Color.White,
        iconContentColor = Color.LightGray,
        titleContentColor = Color.Black,
        textContentColor = Color.Gray
    )
}

fun String.printLengthIfNotBlank() {
    if (isNotBlank()) {
        println(length)
    }
}

class PrintLengthScope() {
    fun String.printLength() {
        println(length)
    }

    fun checkLength(text: String) {
        text.printLength()
    }
}

fun processText(text: String, printLength: String.() -> Unit) {
    text.printLength()
}


@Composable
fun LambdaSample() {
    var count by remember {
        mutableIntStateOf(0)
    }
//    val scope = PrintLengthScope()
//    scope.checkLength("Hello")
    processText(text = "Hello") { println(length) }
    Column {
        Text(text = "Count = $count")
        IconButton(onClick = { count++ }) {
            Icon(painter = painterResource(id = R.drawable.info), contentDescription = "")
        }
    }
}
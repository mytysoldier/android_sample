package com.example.hellocompose2

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellocompose2.ui.entity.Animal
import com.example.hellocompose2.ui.screen.AlertSample
import com.example.hellocompose2.ui.screen.AnimalSelection
import com.example.hellocompose2.ui.screen.AnimalSelection2
import com.example.hellocompose2.ui.screen.CounterSample
import com.example.hellocompose2.ui.screen.LambdaSample
import com.example.hellocompose2.ui.screen.ScrollSample
import com.example.hellocompose2.ui.screen.TextFieldSample
import com.example.hellocompose2.ui.theme.HelloCompose2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloCompose2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
//                            Greeting("Compose")
//                            CounterSample()
//                            TextFieldSample()
//                            ScrollSample()
//                            val animals = listOf(
//                                Animal(R.drawable.dog, "Dog"),
//                                Animal(R.drawable.dog, "Cat"),
//                                Animal(R.drawable.dog, "Bird")
//                            )
//                            AnimalSelection2(animals)
//                            AlertSample()
                            LambdaSample()
                        }
                    }
                }
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Compose")
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    ModifierSample()
//    ImageSample()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloCompose2Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierSample() {
    Text(
        text = "I like Compose", modifier = Modifier
            .clickable { println("Click") }
            .size(width = 200.dp, height = 100.dp)
            .background(
                brush = Brush.linearGradient(listOf(Color.White, Color.Gray)),
                shape = RoundedCornerShape(20.dp)
            )
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
            .padding(10.dp)
    )
}


//@Preview(showBackground = true)
@Composable
fun ImageSample() {
    Image(painter = painterResource(id = R.drawable.dog), contentDescription = "A dog image")
}

@Preview(showBackground = true)
@Composable
fun ColumnSample() {
    Column {
        Text(text = "Good Morning")
        Text(text = "Good Night")
        Text(text = "Good Morning")
        Text(text = "Good Morning")
    }
}

@Preview(showBackground = true)
@Composable
fun RowSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BoxSample() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(100.dp)
        )
        Text(text = "This is a dog", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun AbsoluteSizeSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.size(width = 150.dp, height = 200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RelativeToParentSample() {
    Column(modifier = Modifier.width(300.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(0.7f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RelativeToSiblingsSample() {
    Row(modifier = Modifier.width(600.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.weight(2f)
        )
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RelativeToSiblings2() {
    Row(modifier = Modifier.width(500.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.width(100.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
    }
}
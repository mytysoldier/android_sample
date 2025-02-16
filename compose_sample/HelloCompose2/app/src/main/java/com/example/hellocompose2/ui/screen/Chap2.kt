package com.example.hellocompose2.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.hellocompose2.R
import com.example.hellocompose2.ui.entity.Animal

@Composable
fun CounterSample() {
    var count by remember {
        mutableIntStateOf(0)
    }
    Text(text = "$count", modifier = Modifier.clickable { count++ })
}

@Composable
fun TextFieldSample() {
    var text by remember {
        mutableStateOf("")
    }
    TextField(value = text, onValueChange = {
        println(it)
        text = it
    })
}

@Composable
fun ScrollSample() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(state = scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Image(
            painter = painterResource(id = R.drawable.dog), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Image(
            painter = painterResource(id = R.drawable.dog), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
    }
}

@Composable
fun AnimalSelection2(animals: List<Animal>) {
    var selectedAnimal by remember {
        mutableStateOf<Animal?>(null)
    }
    Column {
        Message(animal = selectedAnimal?.text)
        AnimalList(animals = animals, onAnimalClick = { selectedAnimal = it })
    }

}

@Composable
fun AnimalSelection() {
    Column {
        Text(
            text = "Select an image.",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dog), contentDescription = "",
                )
                Text(text = "Dog")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dog), contentDescription = "",
                )
                Text(text = "Dog")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dog), contentDescription = "",
                )
                Text(text = "Dog")
            }
        }
    }
}

@Composable
fun Message(animal: String?) {
    Column {
        Text(
            text = "Select an image.",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        if (animal != null) {
            Text(
                text = "$animal is selected.",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
        }
    }
}

@Composable
fun AnimalList(animals: List<Animal>, onAnimalClick: (Animal) -> Unit) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        for (animal in animals) {
            AnimalCard(animal = animal, onClick = onAnimalClick, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun AnimalCard(animal: Animal, onClick: (Animal) -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable { onClick(animal) }
    ) {
        Image(painter = painterResource(id = animal.resourceId), contentDescription = "")
        Text(animal.text)
    }
}
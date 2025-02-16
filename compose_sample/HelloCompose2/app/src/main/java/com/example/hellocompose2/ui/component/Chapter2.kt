package com.example.hellocompose2.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hellocompose2.R


//@Preview(showBackground = true)
@Composable
fun SpacerSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "",
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(50.dp))
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "",
            modifier = Modifier.weight(1f)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun PaddingSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "",
            modifier = Modifier
                .width(100.dp)
                .padding(10.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "",
            modifier = Modifier
                .width(100.dp)
                .padding(10.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun ArrangementSample() {
    Column(
        modifier = Modifier
            .height(400.dp)
            .width(100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = AbsoluteAlignment.Right
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog), contentDescription = "",
            modifier = Modifier.size(70.dp),
        )
        Image(
            painter = painterResource(id = R.drawable.dog), contentDescription = "",
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.Start),
        )
        Image(
            painter = painterResource(id = R.drawable.dog), contentDescription = "",
            modifier = Modifier.size(70.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NestedkaLayoutSample() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dog), contentDescription = "",
                modifier = Modifier.size(100.dp),
            )
            Image(
                painter = painterResource(id = R.drawable.dog), contentDescription = "",
                modifier = Modifier.size(100.dp),
            )
            Image(
                painter = painterResource(id = R.drawable.dog), contentDescription = "",
                modifier = Modifier.size(100.dp),
            )
        }
    }
}

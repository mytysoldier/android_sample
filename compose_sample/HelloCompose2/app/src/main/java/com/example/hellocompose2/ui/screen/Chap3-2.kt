package com.example.hellocompose2.ui.screen

import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hellocompose2.R


@Preview(showBackground = true)
@Composable
fun OutLinedSamplePreview() {
    OutlinedTextField(value = "Customized TextField", onValueChange = {},
        label = { Text(text = "TextField") },
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.info), contentDescription = "")
        })
}
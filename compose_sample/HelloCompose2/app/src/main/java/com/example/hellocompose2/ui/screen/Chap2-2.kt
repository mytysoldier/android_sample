package com.example.hellocompose2.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hellocompose2.ui.theme.HelloCompose2Theme

@Composable
fun OnOffSwitch(on: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Off", style = MaterialTheme.typography.titleLarge)
        Switch(checked = on, onCheckedChange = {}, modifier = Modifier.padding(horizontal = 4.dp))
        Text(text = "On", style = MaterialTheme.typography.titleLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun OnOffSwitchPreview() {
    OnOffSwitch(on = true)
}

@Preview
@Composable
fun OnOffSwitchPreviewWithTheme() {
    HelloCompose2Theme {
        Surface {
            OnOffSwitch(on = false)
        }
    }
}
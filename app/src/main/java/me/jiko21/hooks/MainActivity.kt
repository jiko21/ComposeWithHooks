package me.jiko21.hooks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.jiko21.hooks.components.SampleDialog
import me.jiko21.hooks.hooks.useModal
import me.jiko21.hooks.ui.theme.HooksSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HooksSampleTheme {
                Container()
            }
        }
    }
}

@Composable
fun Container() {
    val (isOpen, toggleClose) = useModal()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Button(
            onClick = toggleClose,
        ) {
            Text("Click me")
        }
        SampleDialog(isOpened = isOpen, onDismiss = toggleClose, onOk = toggleClose)
    }
}

@Preview(showBackground = true)
@Composable
fun ContainerPreview() {
    HooksSampleTheme {
        Container()
    }
}
package me.jiko21.hooks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
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
    val (isOpen1, toggleClose1) = useModal()
    val (isOpen2, toggleClose2) = useModal()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Button(
                onClick = toggleClose1,
            ) {
                Text("Click me1")
            }
            Button(
                onClick = toggleClose2,
            ) {
                Text("Click me2")
            }
        }
        SampleDialog(
            text = "modal1",
            isOpened = isOpen1,
            onDismiss = toggleClose1,
            onOk = toggleClose1
        )

        SampleDialog(
            text = "modal2",
            isOpened = isOpen2,
            onDismiss = toggleClose2,
            onOk = toggleClose2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContainerPreview() {
    HooksSampleTheme {
        Container()
    }
}
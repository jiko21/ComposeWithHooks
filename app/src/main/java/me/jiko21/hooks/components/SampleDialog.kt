package me.jiko21.hooks.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SampleDialog(text: String, isOpened: Boolean, onDismiss: () -> Unit, onOk: () -> Unit) {

    if (isOpened) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("sample") },
            text = {
                Text(text)
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onOk()
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismiss
                ) {
                    Text("Cancel")
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSampleDialog() {
    SampleDialog("text",true, onDismiss = {}, onOk = {})
}

package me.jiko21.hooks.hooks

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun useModal(): Pair<Boolean, () -> Unit> {
    val (isOpen, setIsOpen) = remember { mutableStateOf(false) }

    val toggleClose = fun() {
        setIsOpen(!isOpen)
    }
    return isOpen to toggleClose
}

package org.zr8c.cincinnati

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Cincinnati",
    ) {
        App()
    }
}
package org.zr8c.cincinnati

import androidx.compose.material.*
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.zr8c.cincinnati.data.cincinnatiColours
import org.zr8c.cincinnati.ui.CityNameGuesserUI

@Composable
@Preview
fun App() {
    MaterialTheme(
        colors = cincinnatiColours
    ) {
        CityNameGuesserUI()
    }
}


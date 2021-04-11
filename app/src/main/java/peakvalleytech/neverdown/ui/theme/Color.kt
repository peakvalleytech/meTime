package peakvalleytech.neverdown.ui.theme

import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
//<?xml version="1.0" encoding="utf-8"?>
//<resources>
//<color name="colorPrimary">#A7E2A7</color>
//<color name="colorPrimaryDark">#F5F6E0</color>
//<color name="colorAccent">#03DAC5</color>
//</resources>
val colorPrimary = Color(0xFF_A7E2A7)
val colorPrimaryDark = Color(0xFF_F5F6E0)
val colorAccent = Color(0xFF_009688)

@Composable
fun buttonColors() = ButtonDefaults.buttonColors(contentColor = colorPrimaryDark,
    backgroundColor = colorAccent)
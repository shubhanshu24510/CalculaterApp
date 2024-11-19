package com.shubhans.cicdcalculater.presentation

import com.shubhans.cicdcalculater.domain.CalculaterAction

data class CalculaterUiAction(
    val text: String?,
    val highlightLevel: HighlightLevel,
    val action: CalculaterAction,
    val content @Composable() -> Unit = {},
)

sealed interface HighlightLevel {
    object Neutral : HighlightLevel
    object SemiHighlighted : HighlightLevel
    object Highlighted : HighlightLevel
    object StronglyHighlighted : HighlightLevel
}

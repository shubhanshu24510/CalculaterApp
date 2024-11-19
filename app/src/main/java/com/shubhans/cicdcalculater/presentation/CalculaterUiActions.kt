package com.shubhans.cicdcalculater.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import com.shubhans.cicdcalculater.domain.CalculaterAction
import com.shubhans.cicdcalculater.domain.Operation

val CalculationActions = listOf(
    CalculaterUiAction(
        text = "AC",
        highlightLevel = HighlightLevel.Highlighted,
        action = CalculaterAction.Clear
    ),
    CalculaterUiAction(
        text = "()",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculaterAction.Parenthesis
    ),
    CalculaterUiAction(
        text = "%",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculaterAction.Operation(Operation.PERCENT)
    ),
    CalculaterUiAction(
        text = "÷",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculaterAction.Operation(Operation.DIVIDE)
    ),
    CalculaterUiAction(
        text = "7",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(7)
    ),
    CalculaterUiAction(
        text = "8",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(8)
    ),
    CalculaterUiAction(
        text = "9",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(9)
    ),
    CalculaterUiAction(
        text = "×",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculaterAction.Operation(Operation.MULTIPLY)
    ),

    CalculaterUiAction(
        text = "4",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(4)
    ),
    CalculaterUiAction(
        text = "5",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(5)
    ),
    CalculaterUiAction(
        text = "6",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(6)
    ),
    CalculaterUiAction(
        text = "-",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculaterAction.Operation(Operation.SUBTRACT)
    ),

    CalculaterUiAction(
        text = "1",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(1)
    ),
    CalculaterUiAction(
        text = "2",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(2)
    ),
    CalculaterUiAction(
        text = "3",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(3)
    ),
    CalculaterUiAction(
        text = "+",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculaterAction.Operation(Operation.ADD)
    ),

    CalculaterUiAction(
        text = "0",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Number(0)
    ),
    CalculaterUiAction(
        text = ".",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculaterAction.Decimal
    ),
    CalculaterUiAction(
        text = "null,
                highlightLevel = HighlightLevel . Neutral,
        action = CalculaterAction.Delete,
        content = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Delete",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    ),
    CalculaterUiAction(
        text = "=",
        highlightLevel = HighlightLevel.StronglyHighlighted,
        action = CalculaterAction.Calculate
    ),
)
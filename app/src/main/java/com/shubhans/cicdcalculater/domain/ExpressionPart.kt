package com.shubhans.cicdcalculater.domain

sealed interface ExpressionPart {
    data class Number(val value: Double) : ExpressionPart
    data class Operation(val operation: com.shubhans.cicdcalculater.domain.Operation) : ExpressionPart
    data class Parenthesis(val type: ParenthesisType) : ExpressionPart
}

sealed interface ParenthesisType {
    object Open : ParenthesisType
    object Close : ParenthesisType
}
package com.shubhans.cicdcalculater.domain


sealed interface CalculaterAction {
    data class Number(val number: Int) : CalculaterAction
    data class Operation(val operation:com.shubhans.cicdcalculater.domain.Operation ) : CalculaterAction
    object Clear : CalculaterAction
    object Delete : CalculaterAction
    object Parenthesis : CalculaterAction
    object Calculate : CalculaterAction
    object Decimal : CalculaterAction
}
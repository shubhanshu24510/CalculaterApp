package com.shubhans.cicdcalculater.domain

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    PERCENT('%')
}

val operationSymbols = Operation.entries.map { it.symbol }.joinToString("")

fun OperationFromSymbol(symbol: Char): Operation {
    return Operation.values().find { it.symbol == symbol }
        ?: throw IllegalArgumentException("Unknown operation symbol: $symbol")
}
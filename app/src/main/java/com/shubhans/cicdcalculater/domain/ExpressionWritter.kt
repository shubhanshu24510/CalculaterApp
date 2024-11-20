package com.shubhans.cicdcalculater.domain

class ExpressionWritter {

    var expression = ""

    fun processAction(action: CalculaterAction) {
        when (action) {
            is CalculaterAction.Number -> expression += action.number
            is CalculaterAction.Operation -> {
                if (canEnterOperation(action.operation)) {
                    expression += action.operation.symbol
                }
            }

            is CalculaterAction.Clear -> expression = ""
            is CalculaterAction.Delete -> expression = expression.dropLast(1)
            is CalculaterAction.Parenthesis -> processParentheses()
            is CalculaterAction.Calculate ->{
                val parser = ExpressionParser(prepareForCalculation())
                val evaluator = ExpressionEvaluator(parser.parse())
                expression = evaluator.evaluate().toString()
            }
            is CalculaterAction.Decimal -> {
                if (canEnterDecimal()) {
                    expression += "."
                }
            }
        }
    }

    private fun prepareForCalculation(): String {
        val newExpression = expression.dropLastWhile {
            it in "$operationSymbols(."
        }
        if(newExpression.isEmpty()) {
            return "0"
        }
        return newExpression
    }


    private fun canEnterDecimal(): Boolean {
        if (expression.isEmpty() || expression.last() in "$operationSymbols.()") {
            return false
        }
        return !expression.takeLastWhile {
            it in "0123456789."
        }.contains(".")
    }

    private fun processParentheses() {
        val openingCount = expression.count { it == '(' }
        val closingCount = expression.count { it == ')' }
        expression += when {
            expression.isEmpty() ||
                    expression.last() in "$operationSymbols(" -> "("

            expression.last() in "0123456789)" &&
                    openingCount == closingCount -> return

            else -> ")"
        }
    }

    private fun canEnterOperation(operation: Operation): Boolean {
        if (operation in listOf(Operation.ADD, Operation.SUBTRACT)) {
            return expression.isEmpty() || expression.last() in "$operationSymbols()0123456789"
        }
        return expression.isNotEmpty() || expression.last() in "0123456789)"
    }
}
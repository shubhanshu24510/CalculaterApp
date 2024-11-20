package com.shubhans.cicdcalculater.domain

import org.junit.Assert.*

import org.junit.Test

class ExpressionEvaluatorTest {
    private lateinit var evaluator: ExpressionEvaluator

    @Test
    fun `evaluate simple expression`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Operation(Operation.ADD),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.SUBTRACT),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(3.0),
            )
        )

        assertEquals(4.0, evaluator.evaluate(), 0.0)
    }


    @Test
    fun `evaluate expression with brackets`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Operation(Operation.ADD),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.SUBTRACT),
                ExpressionPart.Number(3.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(3.0),
            )
        )
        assertEquals(7.333333333333334, evaluator.evaluate(), 0.0)
    }

    @Test
    fun `evaluate expression with brackets and nested brackets`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Operation(Operation.ADD),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.SUBTRACT),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(3.0),
            )
        )

        assertEquals(0.6666666666666665, evaluator.evaluate(), 0.0)
    }


    @Test
    fun `evaluate expression with brackets and nested brackets and multiple operations`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Operation(Operation.ADD),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.SUBTRACT),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(2.0),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(2.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
            )
        )

        assertEquals(4.0, evaluator.evaluate(), 0.0)
    }

    @Test
    fun `evaluate expression with brackets and nested brackets and multiple operations and multiple brackets`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Operation(Operation.ADD),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.SUBTRACT),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(2.0),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(2.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.ADD),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.SUBTRACT),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(2.0),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(2.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
            )
        )

        assertEquals(4.0, evaluator.evaluate(), 0.0)
    }

    @Test
    fun `evaluate expression with brackets and nested brackets and multiple operations and multiple brackets and decimal`() {
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(4.0),
                ExpressionPart.Operation(Operation.ADD),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.SUBTRACT),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(2.0),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(2.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.ADD),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(5.0),
                ExpressionPart.Operation(Operation.SUBTRACT),
                ExpressionPart.Parenthesis(ParenthesisType.Open),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(5.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(3.0),
                ExpressionPart.Operation(Operation.MULTIPLY),
                ExpressionPart.Number(2.0),
                ExpressionPart.Operation(Operation.DIVIDE),
                ExpressionPart.Number(2.0),
                ExpressionPart.Parenthesis(ParenthesisType.Close),
                ExpressionPart.Operation(Operation.ADD),
                ExpressionPart.Number(0.5),
            )
        )

        assertEquals(4.5, evaluator.evaluate(), 0.0)
    }

}
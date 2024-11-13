package com.shubhans.cicdcalculater.domain

import org.junit.Assert.*
import org.junit.Test

class ExpressionParserTest {

    private lateinit var parser: ExpressionParser

    @Test
    fun `parse simple expression`() {
        // Given
        parser = ExpressionParser("3+5-3*4/3")
        // Do something here
        val actual = parser.parse()
        val expected = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.Operation(Operation.ADD),
            ExpressionPart.Number(5.0),
            ExpressionPart.Operation(Operation.SUBTRACT),
            ExpressionPart.Number(3.0),
            ExpressionPart.Operation(Operation.MULTIPLY),
            ExpressionPart.Number(4.0),
            ExpressionPart.Operation(Operation.DIVIDE),
            ExpressionPart.Number(3.0)
        )
        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `parse expression with parentheses`() {
        parser = ExpressionParser("4-(4*5)")
        val actual = parser.parse()

        val expected = listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.Operation(Operation.SUBTRACT),
            ExpressionPart.Parenthesis(ParenthesisType.Open),
            ExpressionPart.Number(4.0),
            ExpressionPart.Operation(Operation.MULTIPLY),
            ExpressionPart.Number(5.0),
            ExpressionPart.Parenthesis(ParenthesisType.Close)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `parse expression with decimal numbers`() {
        parser = ExpressionParser("1.5+2.5")
        val autual = parser.parse()
        val expected = listOf(
            ExpressionPart.Number(1.5),
            ExpressionPart.Operation(Operation.ADD),
            ExpressionPart.Number(2.5)
        )
        assertEquals(expected, autual)
    }

    @Test
    fun `parse expression with all operations`() {
        parser = ExpressionParser("1+2-3*4/5%6")
        val actual = parser.parse()
        val expected = listOf(
            ExpressionPart.Number(1.0),
            ExpressionPart.Operation(Operation.ADD),
            ExpressionPart.Number(2.0),
            ExpressionPart.Operation(Operation.SUBTRACT),
            ExpressionPart.Number(3.0),
            ExpressionPart.Operation(Operation.MULTIPLY),
            ExpressionPart.Number(4.0),
            ExpressionPart.Operation(Operation.DIVIDE),
            ExpressionPart.Number(5.0),
            ExpressionPart.Operation(Operation.PERCENT),
            ExpressionPart.Number(6.0)
        )
        assertEquals(expected, actual)
    }
}
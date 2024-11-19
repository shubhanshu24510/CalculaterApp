package com.shubhans.cicdcalculater.domain

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ExpressionWritterTest {
    private lateinit var writer: ExpressionWritter

    @Before
    fun setUp() {
        writer = ExpressionWritter()
    }

    @Test
    fun `Initial parentheses parsed`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+4)", writer.expression)
    }

    @Test
    fun `Initial parentheses parsed with operation`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+4x3)", writer.expression)
    }

    @Test
    fun `Initial parentheses parsed with operation and nested parentheses`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+(4x3))", writer.expression)
    }

    @Test
    fun `Initial parentheses parsed with operation and nested parentheses and operation`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+(4x3)/2)", writer.expression)
    }

    @Test
    fun `Initial parentheses parsed with operation and nested parentheses and operation and nested parentheses`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+(4x3)/2x(2)", writer.expression)
    }


    @Test
    fun `Initial parentheses parsed with operation and nested parentheses and operation and nested parentheses and operation`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+(4x3)/2x(2/2)", writer.expression)
    }

    @Test
    fun `Initial parentheses parsed with operation and nested parentheses and operation and nested parentheses and operation and nested parentheses`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.SUBTRACT))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+(4x3)/2x(2/2)+(5-(3x5))", writer.expression)
    }

    @Test
    fun `Initial parentheses parsed with operation and nested parentheses and operation and nested parentheses and operation and nested parentheses and operation`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.SUBTRACT))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+(4x3)/2x(2/2)+(5-(3x5)/2)", writer.expression)

    }


    @Test
    fun `Initial parentheses parsed with operation and nested parentheses and operation and nested parentheses and operation and nested parentheses and operation and nested parentheses`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.SUBTRACT))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+(4x3)/2x(2/2)+(5-(3x5)/2x(2/2)", writer.expression)
    }

    @Test
    fun `Initial parentheses parsed with operation and nested parentheses and operation and nested parentheses and operation and nested parentheses and operation and nested parentheses and operation`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.SUBTRACT))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.SUBTRACT))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals("(5+(4x3)/2x(2/2)+(5-(3x5)/2x(2/2)+(5-(3x5)/2x(2/2)", writer.expression)

    }

    @Test
    fun `Initial parentheses parsed with operation and nested parentheses and operation and nested parentheses and operation and nested parentheses and operation and nested parentheses and operation and nested parentheses`() {
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(4))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.SUBTRACT))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.SUBTRACT))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.SUBTRACT))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.ADD))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Operation(Operation.SUBTRACT))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(3))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Number(5))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.MULTIPLY))
        writer.processAction(CalculaterAction.Parenthesis)
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Operation(Operation.DIVIDE))
        writer.processAction(CalculaterAction.Number(2))
        writer.processAction(CalculaterAction.Parenthesis)

        assertEquals(
            "(5+(4x3)/2x(2/2)+(5-(3x5)/2x(2/2)+(5-(3x5)/2x(2/2)+(5-(3x5)/2x(2/2)+(5-(3x5)/2x(2/2)",
            writer.expression
        )

    }
}
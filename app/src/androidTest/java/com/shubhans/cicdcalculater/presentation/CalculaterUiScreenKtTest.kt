package com.shubhans.cicdcalculater.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.shubhans.cicdcalculater.MainActivity
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculaterUiScreenKtTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)
    private lateinit var viewModel: CalculaterViewModel

    @Before
    fun setUp() {
        viewModel = CalculaterViewModel()
    }

    @Test
    fun enter_expression_show_correct_result_display() {

        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("5").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("1.0").assertIsDisplayed()
    }

    @Test
    fun eneter_expression_show_complex_result_display() {

        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("×").performClick()
        composeRule.onNodeWithText("9").performClick()
        composeRule.onNodeWithText("÷").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("7.0").assertIsDisplayed()
    }
}
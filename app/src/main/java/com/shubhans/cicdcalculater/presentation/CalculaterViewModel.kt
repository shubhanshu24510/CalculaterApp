package com.shubhans.cicdcalculater.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.shubhans.cicdcalculater.domain.CalculaterAction
import com.shubhans.cicdcalculater.domain.ExpressionWritter

class CalculaterViewModel(
    private val writter: ExpressionWritter = ExpressionWritter()
) : ViewModel() {

    var expression by mutableStateOf("")
        private set

    fun onAction(action: CalculaterAction) {

        writter.processAction(action)
        this.expression = writter.expression
    }
}
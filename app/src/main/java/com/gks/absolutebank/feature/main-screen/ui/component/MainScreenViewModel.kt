package com.gks.absolutebank.feature.main


import android.icu.util.Currency
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.gks.absolutebank.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainScreenViewModel() : ViewModel() {
  val state = MutableStateFlow(MainScreenViewState())

  fun getIcon(currency: String): Int {
    return when(currency) {
      "USD" -> R.drawable.ic_usd_10_20
      "RUB" -> R.drawable.ic_rub_12_16
      "EUR" -> R.drawable.ic_eur_17_16
      else -> R.drawable.ic_rub_12_16
    }
  }

  fun getCurrencySign(currency: String): String {
    return when(currency) {
      "RUB" -> "®"
      "USD" -> "$"
      else -> ""
    }
  }

  fun updateExpansionState(index: Int) {
    var modifiedList = state.value.accountsExpansionStates
    modifiedList[index] = !state.value.accountsExpansionStates[index]
    state.update {
      it.copy(
        accountsExpansionStates = modifiedList
      )
    }
    //println(state.value.accountsExpansionStates)
  }
}
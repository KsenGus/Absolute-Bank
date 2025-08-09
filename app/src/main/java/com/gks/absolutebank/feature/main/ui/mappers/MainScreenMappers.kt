package com.gks.absolutebank.feature.main.ui.mappers

import com.gks.absolutebank.R

fun getCurrencySign(currency: String): String {
  return when(currency) {
    "RUB" -> "₽"
    "USD" -> "$"
    else -> ""
  }
}

fun getIcon(currency: String): Int {
  return when(currency) {
    "USD" -> R.drawable.ic_usd_10_20
    "RUB" -> R.drawable.ic_rub_12_16
    "EUR" -> R.drawable.ic_eur_17_16
    else -> R.drawable.ic_rub_12_16
  }
}
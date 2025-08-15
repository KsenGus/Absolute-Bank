package com.gks.absolutebank.feature.detail.ui.mappers

internal fun maskCardNumber(number: String): String {
  return "****" + number.takeLast(4)
}
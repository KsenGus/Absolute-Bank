package com.gks.absolutebank.feature.detail.ui.mappers

internal fun mapCardNumber(number: String): String {
  return "****" + number.takeLast(4)
}
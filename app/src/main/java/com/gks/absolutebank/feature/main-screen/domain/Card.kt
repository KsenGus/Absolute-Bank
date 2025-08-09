package com.gks.absolutebank.feature.main

import androidx.compose.runtime.Immutable

@Immutable
data class Card(
  val id: String,
  val number: String,
  val name: String,
  val cardType: String,
  val paymentSystem: String,
  val status: String
)

package com.gks.absolutebank.feature.main

import androidx.compose.runtime.Immutable

@Immutable
data class Account(
  val id: String,
  val number: String,
  val balance: Double,
  val currency: String,
  val status: String,
  val cards: List<Card>
)


package com.gks.absolutebank.feature.main

import androidx.compose.runtime.Immutable

@Immutable
data class Deposit(
  val id: String,
  val name: String,
  val balance: Double,
  val currency: String,
  val status: String,
  val term: String,
  val rate: Double,
  val minSize: Double
)
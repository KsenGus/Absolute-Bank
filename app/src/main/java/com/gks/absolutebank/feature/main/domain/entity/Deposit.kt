package com.gks.absolutebank.feature.main.domain.entity

import androidx.compose.runtime.Immutable

@Immutable
data class Deposit(
  val id: Id,
  val name: String,
  val balance: Double,
  val currency: String,
  val status: String,
) {
  @JvmInline
  value class Id (private val id: Int)
}
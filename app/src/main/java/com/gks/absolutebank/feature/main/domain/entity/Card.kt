package com.gks.absolutebank.feature.main.domain.entity

import androidx.compose.runtime.Immutable

@Immutable
data class Card(
  val id: Id,
  val number: String,
  val name: String,
  val cardType: String,
  val paymentSystem: String,
  val status: String
) {
  @JvmInline
  value class Id (private val id: String)
}

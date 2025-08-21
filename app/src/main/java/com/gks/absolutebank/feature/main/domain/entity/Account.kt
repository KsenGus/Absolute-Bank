package com.gks.absolutebank.feature.main.domain.entity

import androidx.compose.runtime.Immutable

@Immutable
data class Account(
  val id: Id,
  val number: String,
  val balance: Double,
  val currency: String,
  val status: String,
  val cards: List<Card>,
  val isExpanded: Boolean
) {
  @JvmInline
  value class Id (private val id: Int)
}
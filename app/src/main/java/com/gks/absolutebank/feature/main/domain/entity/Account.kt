package com.gks.absolutebank.feature.main.domain.entity

import androidx.compose.runtime.Immutable
import com.gks.absolutebank.feature.main1.Id

@Immutable
data class Account(
  val id: Id,
  val number: String,
  val balance: Double,
  val currency: String,
  val status: String,
  val cards: List<Card>,
  val isExpanded: Boolean
)
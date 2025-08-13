package com.gks.absolutebank.feature.detail.domain.entity

import androidx.compose.runtime.Immutable
import com.gks.absolutebank.feature.main1.Id

@Immutable
data class Card(
  val id: Id,
  val number: String,
  val name: String,
  val cardType: String,
  val paymentSystem: String,
  val status: String,
  val expiredAt: String,
  val balance: Double,
  val currency: String
)
package com.gks.absolutebank.feature.main.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class CardDetailsResponse(
  val id: Int,
  val accountId: Int,
  val number: String,
  val expiredAt: String,
  val paymentSystem: String,
  val status: String,
  val name: String
)
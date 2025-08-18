package com.gks.absolutebank.feature.main.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class AccountListResponse (
  val accounts: List<AccountData>
)

@Serializable
data class AccountData(
  val accountId: Int,
  val number: String,
  val balance: Double,
  val currency: String,
  val status: String,
  val cards: List<CardData>
)

@Serializable
data class CardData(
  val card_id: Int,
  val number: String,
  val status: String,
  val name: String,
  val payment_system: String,
  val card_type: String
)
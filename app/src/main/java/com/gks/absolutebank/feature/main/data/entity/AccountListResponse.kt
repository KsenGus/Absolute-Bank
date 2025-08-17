package com.gks.absolutebank.feature.main.data.entity

data class AccountListResponse (
  val accounts: List<AccountData>
)

data class AccountData(
  val accountId: Int,
  val number: String,
  val balance: Double,
  val currency: String,
  val status: String,
  val cards: List<CardData>
)

data class CardData(
  val card_id: Int,
  val number: String,
  val status: String,
  val name: String,
  val payment_system: String,
  val card_type: String
)
package com.gks.absolutebank.feature.main.data.mappers

import com.gks.absolutebank.feature.main.data.entity.AccountData
import com.gks.absolutebank.feature.main.data.entity.CardData
import com.gks.absolutebank.feature.main.data.entity.DepositData
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.Card
import com.gks.absolutebank.feature.main.domain.entity.Deposit

internal fun AccountData.toDomainModel() : Account {
  return Account(
    id = Account.Id(id = accountId),
    number = number,
    balance = balance,
    currency = currency,
    status = status,
    cards = cards.map { it.toDomainModel() },
    isExpanded = false
  )
}

internal fun CardData.toDomainModel(): Card {
  return Card(
    id = Card.Id(id = card_id),
    number = number,
    name = name,
    cardType = card_type,
    paymentSystem = payment_system,
    status = status
  )
}

internal fun DepositData.toDomainModel() : Deposit {
  return Deposit(
    id = Deposit.Id(id = depositId),
    balance = balance,
    currency = currency,
    status = status,
    name = name
  )
}
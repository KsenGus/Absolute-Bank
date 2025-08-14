package com.gks.absolutebank.feature.main.ui

import androidx.compose.runtime.Immutable
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.Card
import com.gks.absolutebank.feature.main.domain.entity.Deposit

@Immutable
data class MainScreenViewState(
  val accountList: List<Account> = listOf(
    Account(
      id = Account.Id("sfjdkf3805e"),
      number = "3642892300",
      balance = 457334.00,
      currency = "USD",
      status = "active",
      cards = listOf(
        Card(
          id = Card.Id("sfjdkf3805e"),
          number = "3642892300",
          cardType = "debit",
          status = "active",
          paymentSystem = "visa",
          name = "Карта зарплатная"
        )
      ),
      isExpanded = false
    ),
    Account(
      id = Account.Id("sfjdkf3805e"),
      number = "3642892300",
      balance = 457334.00,
      currency = "RUB",
      status = "active",
      cards = listOf(
        Card(
          id = Card.Id("sfjdkf3805e"),
          number = "3642892300",
          cardType = "debit",
          status = "active",
          paymentSystem = "visa",
          name = "Карта зарплатная"
        )
      ),
      isExpanded = false
    )
  ),
  val depositList: List<Deposit> = listOf(
    Deposit(
      id = Deposit.Id("sfjdkf3805e"),
      term = "31.08.2024",
      rate = 7.68,
      minSize = 100.00,
      balance = 457334.00,
      currency = "USD",
      status = "active",
      name = "deposit"
    ),
    Deposit(
      id = Deposit.Id("sfjdkf3805e"),
      term = "31.08.2024",
      rate = 7.68,
      minSize = 100.00,
      balance = 457334.00,
      currency = "USD",
      status = "active",
      name = "deposit"
    )
  )
)

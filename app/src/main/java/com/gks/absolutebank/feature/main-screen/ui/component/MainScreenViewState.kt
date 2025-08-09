package com.gks.absolutebank.feature.main


data class MainScreenViewState(
  val accountList: List<Account> = listOf(
    Account(
      id = "jksre35i8",
      number = "3642892300",
      balance = 457334.00,
      currency = "USD",
      status = "active",
      cards = listOf(
        Card(
          id = "jksre35i8",
          number = "3642892300",
          cardType = "debit",
          status = "active",
          paymentSystem = "Master",
          name = "Карта зарплатная"
        )
      )
    ),
    Account(
      id = "jksre35i8",
      number = "3642892300",
      balance = 457334.00,
      currency = "RUB",
      status = "active",
      cards = listOf(
        Card(
          id = "jksre35i8",
          number = "3642892300",
          cardType = "debit",
          status = "active",
          paymentSystem = "Visa",
          name = "Карта зарплатная"
        )
      )
    )
  ),
  val accountsExpansionStates: MutableList<Boolean> = MutableList(accountList.size) { _ -> false },
  val depositList: List<Deposit> = listOf(
    Deposit(
      id = "jksre35i8",
      term = "31.08.2024",
      rate = 7.68,
      minSize = 100.00,
      balance = 457334.00,
      currency = "USD",
      status = "active",
      name = "deposit"
    ),
    Deposit(
      id = "jksre35i8",
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

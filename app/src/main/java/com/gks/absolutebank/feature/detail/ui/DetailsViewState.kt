package com.gks.absolutebank.feature.detail.ui

import com.gks.absolutebank.feature.detail.domain.entity.Card
import com.gks.absolutebank.feature.detail.domain.entity.CardActions
import com.gks.absolutebank.feature.detail.domain.entity.Tabs
import com.gks.absolutebank.feature.main1.Id

data class DetailsViewState (
  val cardList: List<Card> = listOf(
    Card(
      id = Id("sfjdkf3805e"),
      number = "3642892300",
      cardType = "debit",
      status = "Активна",
      paymentSystem = "VISA",
      name = "Карта зарплатная",
      expiredAt = "05/22",
      balance = 145.00,
      currency = "USD"
    ),
    Card(
      id = Id("sfjdkf3805e"),
      number = "364890908800",
      cardType = "debit",
      status = "Заблокирована",
      paymentSystem = "MASTER",
      name = "Карта",
      expiredAt = "02/29",
      balance = 4589.80,
      currency = "USD"
    )
  ),
  val blockedCardActions: List<CardActions> = listOf(
    CardActions.RENAME,
    CardActions.REQUISITES,
    CardActions.INFORMATION,
    CardActions.REOBTAIN,
    CardActions.UNBLOCK
  ),
  val activeCardActions: List<CardActions> = listOf(
    CardActions.RENAME,
    CardActions.REQUISITES,
    CardActions.INFORMATION,
    CardActions.OBTAIN,
    CardActions.BLOCK
  ),
  val tabsList: List<Tabs> = listOf(
    Tabs.ACTIONS,
    Tabs.HISTORY,
    Tabs.PAYMENTS
  ),
  val activeTab: Tabs = Tabs.ACTIONS
)
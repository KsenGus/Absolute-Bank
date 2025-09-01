package com.gks.absolutebank.feature.detail.ui

import com.gks.absolutebank.feature.detail.domain.entity.CardActions
import com.gks.absolutebank.feature.detail.domain.entity.Tabs
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.Card
import com.gks.absolutebank.feature.main.domain.entity.CardDetails
import com.gks.absolutebank.feature.main.domain.entity.ContentLoadState

data class DetailsViewState (
  val cardList: List<Card> = emptyList(),
  val accountList: List<Account> = emptyList(),
  val activeAccount: Account? = null,
  val cardDetails: CardDetails? = null,
  val contentLoadState: ContentLoadState = ContentLoadState.NotStarted,
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
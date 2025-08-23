package com.gks.absolutebank.feature.main.ui

import androidx.compose.runtime.Immutable
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.Card
import com.gks.absolutebank.feature.main.domain.entity.ContentLoadState
import com.gks.absolutebank.feature.main.domain.entity.Deposit

@Immutable
data class MainScreenViewState(
  val accountList: List<Account> = emptyList(),
  val depositList: List<Deposit> = emptyList(),
  val contentLoadState: ContentLoadState = ContentLoadState.NotStarted,
  val isRefreshing: Boolean = false
)

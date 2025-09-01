package com.gks.absolutebank.feature.main.domain

import androidx.collection.scatterSetOf
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.CardDetails
import com.gks.absolutebank.feature.main.domain.entity.Deposit
import kotlinx.coroutines.flow.Flow

interface MainScreenRepository {
  val accounts: Flow<List<Account>>
  val deposits: Flow<List<Deposit>>
  val cardDetails: Flow<CardDetails?>

  suspend fun fetchAccounts()
  suspend fun fetchDeposits()
  suspend fun fetchCardData(id: Int)
}
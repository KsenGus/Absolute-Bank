package com.gks.absolutebank.feature.main.data

import com.gks.absolutebank.api.AbsoluteBankApi
import com.gks.absolutebank.feature.main.data.entity.AccountData
import com.gks.absolutebank.feature.main.data.mappers.toDomainModel
import com.gks.absolutebank.feature.main.domain.MainScreenRepository
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.Deposit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class MainScreenDataRepository @Inject constructor(
  private val api: AbsoluteBankApi
): MainScreenRepository {
  private val accountsCache = MutableStateFlow<List<Account>>(emptyList())
  private val depositsCache = MutableStateFlow<List<Deposit>>(emptyList())

  override suspend fun fetchAccounts() {
    val response = api.fetchAccountList()
    accountsCache.value = response.accounts.map { it.toDomainModel() }
  }

  override suspend fun fetchDeposits() {
    val response = api.fetchDepositList()
    depositsCache.value = response.deposits.map { it.toDomainModel() }
  }

  override val accounts: Flow<List<Account>> = accountsCache
  override val deposits: Flow<List<Deposit>> = depositsCache
}

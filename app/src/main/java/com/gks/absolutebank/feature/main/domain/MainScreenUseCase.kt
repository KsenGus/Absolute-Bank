package com.gks.absolutebank.feature.main.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainScreenUseCase @Inject constructor(
  private val repository: MainScreenRepository,
  private val scope: CoroutineScope
) {

  fun fetchAccounts() {
    scope.launch {
        repository.fetchAccounts()
    }
  }

  val accounts = repository.accounts


  fun fetchDeposits() {
    scope.launch {
        repository.fetchDeposits()
    }
  }

  val deposits = repository.deposits
}
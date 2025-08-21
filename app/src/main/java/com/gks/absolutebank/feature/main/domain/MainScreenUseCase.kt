package com.gks.absolutebank.feature.main.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.ThreadLocalRandom
import javax.inject.Inject


class MainScreenUseCase @Inject constructor(
  private val repository: MainScreenRepository,
  private val scope: CoroutineScope
) {

  suspend fun fetchAccounts() {
//    scope.launch {
//      runCatching {
        repository.fetchAccounts()
        println("hello" + repository.accounts)
//      }
//        .onFailure {
//          throw it
//        }
//    }
  }

  val accounts = repository.accounts


  fun fetchDeposits() {
    scope.launch {
        repository.fetchDeposits()
    }
  }

  val deposits = repository.deposits
}
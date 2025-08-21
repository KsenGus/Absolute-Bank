package com.gks.absolutebank.feature.main.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import java.util.concurrent.ThreadLocalRandom
import javax.inject.Inject


class MainScreenUseCase @Inject constructor(
  private val repository: MainScreenRepository,
  private val scope: CoroutineScope
) {

  val errorFlow = MutableSharedFlow<Throwable>()
  fun fetchAccounts() {
    scope.launch {
     try {
        repository.fetchAccounts()
      }
      catch (error: Throwable) {
         errorFlow.emit(error)
       }
    }
  }

  val accounts = repository.accounts


  fun fetchDeposits() {
    scope.launch {
      try {
        repository.fetchDeposits()
      }
       catch (error: Throwable) {
         errorFlow.emit(error)
       }
    }
  }

  fun fetchCardData(id: Int) {
    scope.launch {
      try {
        repository.fetchCardData(id)
      }
      catch (error: Throwable) {
        errorFlow.emit(error)
      }
    }
  }

  val deposits = repository.deposits

  val cardDetails = repository.cardDetails
}
package com.gks.absolutebank.feature.main.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import java.util.concurrent.ThreadLocalRandom
import javax.inject.Inject


class MainScreenUseCase @Inject constructor(
  private val repository: MainScreenRepository,
  private val scope: CoroutineScope
) {

  val errorFlow = MutableSharedFlow<Throwable>()
  val refreshing = MutableSharedFlow<Boolean>()
  val loading = MutableSharedFlow<Boolean>()

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

  fun refresh() {
    scope.launch {
      try {
        refreshing.emit(true)
        val accounts = scope.async {
          repository.fetchAccounts()
        }
        val deposits = scope.async {
          repository.fetchDeposits()
        }
        accounts.await()
        deposits.await()
      }
      catch (error: Throwable) {
        errorFlow.emit(error)
      }
      finally {
        refreshing.emit(false)
      }
    }
  }

  fun load() {
    scope.launch {
      try {
        loading.emit(true)
        val accounts = scope.async {
          repository.fetchAccounts()
        }
        val deposits = scope.async {
          repository.fetchDeposits()
        }
        accounts.await()
        deposits.await()
        loading.emit(false)
      }
      catch (error: Throwable) {
        errorFlow.emit(error)
      }
      finally {
        loading.emit(false)
      }
    }
  }

  val deposits = repository.deposits

  val cardDetails = repository.cardDetails
}
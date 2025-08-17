package com.gks.absolutebank.feature.main.domain

import com.gks.absolutebank.feature.main.domain.entity.ContentLoadState
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class MainScreenUseCase @Inject constructor(
  private val repository: MainScreenRepository
)
{
  val contentLoadState = MutableStateFlow<ContentLoadState>(ContentLoadState.NotStarted)

  suspend fun fetchAccounts() {
    try{
      contentLoadState.value = ContentLoadState.Loading
      repository.fetchAccounts()
    }
    catch (error: Throwable) {
      contentLoadState.value = ContentLoadState.Error(error)
    }
  }
  val accounts = repository.accounts
}
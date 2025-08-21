package com.gks.absolutebank.feature.main.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gks.absolutebank.feature.main.domain.MainScreenUseCase
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.ContentLoadState
import com.gks.absolutebank.ui.theme.contentError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.replay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
  private val useCase: MainScreenUseCase
) : ViewModel() {
  val state = MutableStateFlow(MainScreenViewState())

  fun updateExpansionState(account: Account) {
    state.update {
      it.copy(
        accountList = state.value.accountList.mapIndexed { i, item ->
          if (item.id == account.id) {
            item.copy(
              isExpanded = !item.isExpanded
            )
          } else item
        }
      )
    }
  }

  private fun fetchAccounts() {
    if (useCase.errorFlow.replayCache.isEmpty()) {
      updateContentLoadState(ContentLoadState.Loading)
    useCase.fetchAccounts()
    updateContentLoadState(ContentLoadState.Ready)
  } else updateContentLoadState(ContentLoadState.Error(useCase.errorFlow.replayCache.last()))
}

private fun updateAccounts() {
  viewModelScope.launch {
    useCase.accounts.onEach { accounts ->
      state.update {
        it.copy(
          accountList = accounts
        )
      }
    }.launchIn(this)
  }
}

private fun fetchDeposits() {
  if (useCase.errorFlow.replayCache.isEmpty()) {
    updateContentLoadState(ContentLoadState.Loading)
    useCase.fetchDeposits()
    updateContentLoadState(ContentLoadState.Ready)
  } else updateContentLoadState(ContentLoadState.Error(useCase.errorFlow.replayCache.last()))

}

private fun updateDeposits() {
  viewModelScope.launch {
    useCase.deposits.onEach { deposits ->
      state.update {
        it.copy(
          depositList = deposits
        )
      }
    }.launchIn(this)
  }
}

private fun updateContentLoadState(newContentLoadState: ContentLoadState) {
  state.update {
    it.copy(
      contentLoadState = newContentLoadState
    )
  }
}

fun fetchInitialData() {
  fetchAccounts()
  updateAccounts()
  fetchDeposits()
  updateDeposits()
}
}

internal const val VISA_PAYMENT_SYSTEM = "visa"
package com.gks.absolutebank.feature.main.ui


import androidx.lifecycle.ViewModel
import com.gks.absolutebank.feature.main.domain.MainScreenUseCase
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.ContentLoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
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
    try {
      updateContentLoadState(ContentLoadState.Loading)
      useCase.fetchAccounts()
      updateContentLoadState(ContentLoadState.Ready)
    }
    catch (error: Throwable) {
      updateContentLoadState(ContentLoadState.Error(error))
    }
  }

  private fun updateAccounts() {
    useCase.accounts.onEach { accounts ->
      state.update {
        it.copy(
          accountList = accounts
        )
      }
    }
  }

  private fun fetchDeposits() {
    try {
      updateContentLoadState(ContentLoadState.Loading)
      useCase.fetchDeposits()
      updateContentLoadState(ContentLoadState.Ready)
    }
    catch (error: Throwable) {
      updateContentLoadState(ContentLoadState.Error(error))
    }
  }

  private fun updateDeposits() {
    useCase.deposits.onEach { deposits ->
      state.update {
        it.copy(
          depositList = deposits
        )
      }
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
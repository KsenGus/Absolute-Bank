package com.gks.absolutebank.feature.main.ui


import androidx.lifecycle.ViewModel
import com.gks.absolutebank.feature.main.domain.entity.Account
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
  val useCase: MainScreenUseCase
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

  fun fetchAccounts() {
    viewModelScope.launch {
      useCase.fetchAccounts()
    }
  }

  fun updateAccounts() {
    useCase.accounts.onEach { accounts ->
      state.update {
        it.copy(
          accountList = accounts
        )
      }
    }
  }

  fun fetchDeposits() {
    viewModelScope.launch {
      useCase.fetchDeposits()
    }
  }

  fun updateDeposits() {
    useCase.accounts.onEach { deposits ->
      state.update {
        it.copy(
          accountList = deposits
        )
      }
    }
  }

  fun updateContentLoadState() {
    state.update {
      it.copy(
        contentLoadState = useCase.contentLoadState.value
      )
    }
  }
}

internal const val VISA_PAYMENT_SYSTEM = "visa"
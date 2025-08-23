package com.gks.absolutebank.feature.main.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gks.absolutebank.feature.main.domain.MainScreenUseCase
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.ContentLoadState
import com.gks.absolutebank.ui.theme.contentError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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
//
//  private fun fetchAccounts() {
//    updateContentLoadState(ContentLoadState.Loading)
//    useCase.fetchAccounts()
//  }

  private fun updateAccounts() {
    useCase.accounts.onEach { accounts ->
      state.update {
        it.copy(accountList = accounts)
      }
    }.launchIn(viewModelScope)
  }
//
//  private fun fetchDeposits() {
//    updateContentLoadState(ContentLoadState.Loading)
//    useCase.fetchDeposits()
//  }

  private fun updateDeposits() {
    useCase.deposits.onEach { deposits ->
      state.update {
        it.copy(depositList = deposits)
      }
    }.launchIn(viewModelScope)
  }

  private fun updateContentLoadState(newContentLoadState: ContentLoadState) {
    state.update {
      it.copy(
        contentLoadState = newContentLoadState
      )
    }
  }

  private fun observeError() {
    useCase.errorFlow
      .onEach { error ->
        updateContentLoadState(ContentLoadState.Error(error))
      }
      .launchIn(viewModelScope)
  }

  private fun updateIsRefreshingState(newIsRefreshingState: Boolean) {
    state.update {
      it.copy(
        isRefreshing = newIsRefreshingState
      )
    }
  }

  fun onPullToRefreshTrigger() {
    useCase.refresh()
  }

  private fun load() {
    useCase.load()
  }

  private fun observeRefresh() {
    useCase.refreshing
      .onEach { refreshing ->
        updateIsRefreshingState(refreshing)
      }
      .launchIn(viewModelScope)
  }

  private fun observeLoading() {
    useCase.loading
      .onEach { loading ->
        if (loading) {
          updateContentLoadState(ContentLoadState.Loading)
        } else {
          updateContentLoadState(ContentLoadState.Ready)
        }
      }
      .launchIn(viewModelScope)
  }

  fun fetchInitialData() {
    load()
    updateAccounts()
    updateDeposits()
    observeError()
    observeRefresh()
    observeLoading()
  }
}

internal const val VISA_PAYMENT_SYSTEM = "visa"
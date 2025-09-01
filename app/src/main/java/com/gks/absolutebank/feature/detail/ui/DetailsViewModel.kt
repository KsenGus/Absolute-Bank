package com.gks.absolutebank.feature.detail.ui

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gks.absolutebank.feature.detail.domain.entity.Tabs
import com.gks.absolutebank.feature.main.domain.MainScreenUseCase
import com.gks.absolutebank.feature.main.domain.entity.Account
import com.gks.absolutebank.feature.main.domain.entity.ContentLoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@Immutable
@HiltViewModel
class DetailsViewModel @Inject constructor(
  private val useCase: MainScreenUseCase
) : ViewModel() {
  val state = MutableStateFlow(DetailsViewState())

  fun updateActiveTab(tab: Tabs) {
    state.update {
      it.copy(
        activeTab = tab
      )
    }
  }

  private fun updateContentLoadState(newContentLoadState: ContentLoadState) {
    state.update {
      it.copy(
        contentLoadState = newContentLoadState
      )
    }
  }

  fun fetchCardDetails(id: Int) {
    viewModelScope.launch {
      updateContentLoadState(ContentLoadState.Loading)
      useCase.fetchCardData(id)
      updateContentLoadState(ContentLoadState.Ready)
    }
  }

  private fun observeError() {
    useCase.errorFlow
      .onEach { error ->
        updateContentLoadState(ContentLoadState.Error(error))
      }
      .launchIn(viewModelScope)
  }

  fun fetchAccounts() {
    viewModelScope.launch {
      updateContentLoadState(ContentLoadState.Loading)
      useCase.fetchAccounts()
      updateContentLoadState(ContentLoadState.Ready)
    }
  }

  fun getActiveAccount() {
    combine(
      useCase.accounts,
      useCase.cardDetails.filterNotNull(),
      ::Pair
    ).onEach { (accounts, cardDetails) ->
      state.update {
        val activeAccount = accounts.find { account ->
          account.id.id == cardDetails.accountId
        }
        it.copy(
          cardDetails = cardDetails,
          activeAccount = activeAccount,
          cardList = activeAccount?.cards.orEmpty()
        )
      }
      println("helllo" + state.value.cardList)
    }
      .launchIn(viewModelScope)
  }


  fun fetchInitialData(id: Int) {
    fetchCardDetails(id)
    fetchAccounts()
    getActiveAccount()
    observeError()
  }
}

internal const val CARD_STATUS_ACTIVE = "Активна"
internal const val VISA_PAYMENT_SYSTEM = "VISA"
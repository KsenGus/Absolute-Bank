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
import kotlinx.coroutines.flow.emptyFlow
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

  private fun fetchCardDetails(id: Int) {
    var caughtError: Throwable = Exception()
    viewModelScope.launch {
      if (useCase.errorFlow.subscriptionCount.value == 0) {
        updateContentLoadState(ContentLoadState.Loading)
        useCase.fetchCardData(id)
        updateContentLoadState(ContentLoadState.Ready)
      } else {
        useCase.errorFlow.onEach { error ->
          caughtError = error
        }.launchIn(viewModelScope)
        updateContentLoadState(ContentLoadState.Error(caughtError))
        println(caughtError)
      }
    }
  }

  private fun updateCardDetails() {
    useCase.cardDetails.onEach { card ->
      state.update {
        it.copy(
          cardDetails = card
        )
      }
    }
  }


  private fun getActiveAccount() {
    useCase.accounts.onEach { accounts ->
      state.update {
        it.copy(
          activeAccount = accounts.find {
            it.id.id == state.value.cardDetails!!.accountId }
        )
      }
    }
  }

  private fun getCardList() {
    state.update {
      it.copy(
        cardList = state.value.activeAccount!!.cards
      )
    }
  }

  fun fetchInitialData(id: Int) {
    fetchCardDetails(id)
    updateCardDetails()
    getActiveAccount()
    getCardList()
  }

  fun fetchData(id: Int) {
    fetchCardDetails(id)
    updateCardDetails()
  }
}

internal const val CARD_STATUS_ACTIVE = "Активна"
internal const val VISA_PAYMENT_SYSTEM = "VISA"
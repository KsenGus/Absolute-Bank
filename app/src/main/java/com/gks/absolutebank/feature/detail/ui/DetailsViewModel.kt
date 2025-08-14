package com.gks.absolutebank.feature.detail.ui

import androidx.compose.runtime.Immutable
import com.gks.absolutebank.feature.detail.domain.entity.Tabs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

@Immutable
class DetailsViewModel {
  val state = MutableStateFlow(DetailsViewState())

  fun updateActiveTab(tab: Tabs) {
    state.update {
      it.copy(
        activeTab = tab
      )
    }
  }
}

internal const val CARD_STATUS_ACTIVE = "Активна"
internal const val VISA_PAYMENT_SYSTEM = "VISA"
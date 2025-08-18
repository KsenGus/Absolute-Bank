package com.gks.absolutebank.feature.detail.ui

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.gks.absolutebank.feature.detail.domain.entity.Tabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@Immutable
@HiltViewModel
class DetailsViewModel @Inject constructor(): ViewModel() {
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
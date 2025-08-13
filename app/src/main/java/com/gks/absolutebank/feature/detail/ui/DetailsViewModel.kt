package com.gks.absolutebank.feature.detail.ui

import com.gks.absolutebank.feature.detail.domain.entity.Tabs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

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
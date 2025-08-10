package com.gks.absolutebank.feature.main.ui


import androidx.lifecycle.ViewModel
import com.gks.absolutebank.feature.main.domain.entity.Account
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainScreenViewModel() : ViewModel() {
  val state = MutableStateFlow(MainScreenViewState())

  fun updateExpansionState(account: Account) {
    state.update {
      it.copy(
        accountList = state.value.accountList.mapIndexed { i, item ->
          if (item == account) {
            item.copy(
              isExpanded = !item.isExpanded
            )
          } else item.copy(
            isExpanded = item.isExpanded
          )
        }
      )
    }
  }
}
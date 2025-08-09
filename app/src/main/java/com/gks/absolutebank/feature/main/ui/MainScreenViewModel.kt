package com.gks.absolutebank.feature.main.ui


import androidx.lifecycle.ViewModel
import com.gks.absolutebank.R
import com.gks.absolutebank.feature.main.domain.entity.Account
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainScreenViewModel() : ViewModel() {
  val state = MutableStateFlow(MainScreenViewState())

  fun updateExpansionState(account: Account) {
    state.update {
      it.copy(
        accountList = state.value.accountList.map { item ->
          if (item == account) {
            account.copy(
              isExpanded = !item.isExpanded
            )
          } else account.copy(
            isExpanded = item.isExpanded
          )
        }
      )
    }
  }
}
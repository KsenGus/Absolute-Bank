package com.gks.absolutebank.feature.main

import androidx.annotation.ColorLong
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gks.absolutebank.R
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun MainScreenLayout(
  viewModel: MainScreenViewModel
) {

  val state = viewModel.state.collectAsState(MainScreenViewState())

  Column(
    modifier = Modifier
      .background(
        color = Color(0xFF312C39)
      )
      .fillMaxHeight()
      .systemBarsPadding()
  ) {
    Spacer(modifier = Modifier.height(11.dp))
    Text(
      modifier = Modifier.fillMaxWidth(),
      text = stringResource(R.string.main),
      color = Color.White,
      fontSize = 16.sp,
      fontWeight = FontWeight(600),
      textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(11.dp))
    LazyColumn(
      modifier = Modifier
        .background(
          color = Color(0xFF352F3D)
        )
    ) {
      item {
        Text(
          modifier = Modifier
            .padding(16.dp),
          text = stringResource(R.string.accounts),
          color = Color(0xFF706D76)
        )
      }
      itemsIndexed(state.value.accountList) { i, account ->
        AccountLayout(
          viewModel.getCurrencySign(account.currency),
          account.number,
          account.balance,
          iconResource = viewModel.getIcon(account.currency),
          onExpandClick = { viewModel.updateExpansionState(i) },
          isExpanded = state.value.accountsExpansionStates[i],
          cards = state.value.accountList[i].cards
        )
        if(i != state.value.accountList.size - 1 && !state.value.accountsExpansionStates[i])
          HorizontalDivider(
            modifier = Modifier
              .padding(start = 72.dp, end = 16.dp),
            color = Color(0xFF403A47))
      }
      item {
        Box(
          modifier = Modifier
            .background(color = Color(0xFF312C39))
            .fillMaxWidth()
            .height(16.dp)
        )
      }
      item {
        Text(
          modifier = Modifier
            .padding(16.dp),
          text = stringResource(R.string.deposits),
          color = Color(0xFF706D76)
        )
      }
      itemsIndexed(state.value.depositList) {
        i, deposit ->  DepositLayout(
          currency = viewModel.getCurrencySign(deposit.currency),
          name = deposit.name,
          balance = deposit.balance,
          iconResource = viewModel.getIcon(deposit.currency),
          rate = deposit.rate,
          term = deposit.term
        )
        if(i != state.value.depositList.size - 1)
          HorizontalDivider(
            modifier = Modifier
              .padding(start = 72.dp, end = 16.dp),
            color = Color(0xFF403A47))
      }
    }
  }
}


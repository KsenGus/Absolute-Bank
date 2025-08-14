package com.gks.absolutebank.feature.main1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gks.absolutebank.R
import com.gks.absolutebank.feature.main.ui.MainScreenViewModel
import com.gks.absolutebank.feature.main.ui.MainScreenViewState
import com.gks.absolutebank.feature.main.ui.mappers.getCurrencySign
import com.gks.absolutebank.feature.main.ui.mappers.getIcon
import com.gks.absolutebank.ui.theme.Typography

@Composable
fun MainScreenLayout(
  viewModel: MainScreenViewModel
) {

  val state = viewModel.state.collectAsState(MainScreenViewState())

  Column(
    modifier = Modifier
      .background(
        color = MaterialTheme.colorScheme.primary
      )
      .fillMaxHeight()
      .systemBarsPadding()
  ) {
    Spacer(modifier = Modifier.height(11.dp))
    Text(
      modifier = Modifier.fillMaxWidth(),
      text = stringResource(R.string.main),
      color = MaterialTheme.colorScheme.onTertiary,
      style = Typography.titleLarge,
      textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(11.dp))
    LazyColumn(
      modifier = Modifier
        .background(
          color = MaterialTheme.colorScheme.secondary
        )
    ) {
      item {
        Text(
          modifier = Modifier
            .padding(16.dp),
          text = stringResource(R.string.accounts),
          color = MaterialTheme.colorScheme.tertiary
        )
      }
      itemsIndexed(state.value.accountList) { i, account ->
        AccountLayout(
         currency = getCurrencySign(account.currency),
          number = account.number,
          balance = account.balance,
          iconResource = getIcon(account.currency),
          onExpandClick = {
            viewModel.updateExpansionState(account)
          },
          rotation = animateFloatAsState(
              targetValue = if (account.isExpanded) 0f else 180f,
          animationSpec = tween(durationMillis = 200, easing = LinearEasing),
          label = "rotation"
        ).value
        )
        AnimatedVisibility(
          visible = account.isExpanded
        ) {
          account.cards.forEach {
            CardLayout(
              number = it.number,
              status = it.status,
              paymentSystem = it.paymentSystem
            )
            if(i != account.cards.lastIndex)
              HorizontalDivider(
                modifier = Modifier
                  .padding(start = 72.dp, end = 16.dp),
                color = MaterialTheme.colorScheme.secondaryContainer)
          }
        }
        if(i != state.value.accountList.lastIndex)
          HorizontalDivider(
            modifier = Modifier
              .padding(start = 72.dp, end = 16.dp),
            color = MaterialTheme.colorScheme.secondaryContainer)
      }
      item {
        Box(
          modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .height(16.dp)
        )
      }
      item {
        Text(
          modifier = Modifier
            .padding(16.dp),
          text = stringResource(R.string.deposits),
          color = MaterialTheme.colorScheme.tertiary
        )
      }
      itemsIndexed(state.value.depositList) { i, deposit ->
        DepositLayout(
          currency = getCurrencySign(deposit.currency),
          name = deposit.name,
          balance = deposit.balance,
          iconResource = getIcon(deposit.currency),
          rate = deposit.rate,
          term = deposit.term
        )
        if(i != state.value.depositList.size - 1)
          HorizontalDivider(
            modifier = Modifier
              .padding(start = 72.dp, end = 16.dp),
            color = MaterialTheme.colorScheme.secondaryContainer)
      }
    }
  }
}


package com.gks.absolutebank.feature.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gks.absolutebank.R
import com.gks.absolutebank.feature.detail.ui.component.ActionsLayout
import com.gks.absolutebank.feature.detail.ui.component.CardLayout
import com.gks.absolutebank.feature.detail.ui.component.PageIndicator
import com.gks.absolutebank.feature.detail.ui.component.Tabs
import com.gks.absolutebank.ui.theme.Typography

@Composable
fun DetailLayout(
  modifier: Modifier = Modifier,
  viewModel: DetailsViewModel,
  onBackClick: ()->Unit,
  id: Int
) {

val state = viewModel.state.collectAsState(DetailsViewState())
  val pagerState = rememberPagerState(pageCount = {state.value.cardList.size })

  Column(
    modifier = modifier
      .background(
        color = MaterialTheme.colorScheme.primary
      )
      .statusBarsPadding()
      .fillMaxHeight()
  ) {
    Row(
      modifier = Modifier.
      fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 10.dp),
    ) {
      Icon(
        modifier = Modifier.clickable(
          onClick = onBackClick
        ),
        painter = painterResource(R.drawable.ic_left_24),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onTertiary
      )
      Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.cards),
        style = Typography.titleLarge,
        color = MaterialTheme.colorScheme.onTertiary,
        textAlign = TextAlign.Center
      )
    }
    HorizontalPager(
      state = pagerState,
      contentPadding = PaddingValues(vertical = 24.dp, horizontal = 64.dp),
      pageSpacing = 8.dp
    ) { page ->
      val card = state.value.cardList[page]
      CardLayout(
        name = card.name,
        number = card.number,
        isActive = page == pagerState.currentPage,
        text = if(card.status == CARD_STATUS_ACTIVE) stringResource(R.string.balance_string, card.balance, card.currency) else card.status,
        textColor = if(card.status == CARD_STATUS_ACTIVE) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.onError,
        paymentSystemImg = if(card.paymentSystem == VISA_PAYMENT_SYSTEM)  R.drawable.ic_visa_16_6 else R.drawable.ic_mastercard_16_12,
        expiresAt = card.expiredAt
      )
    }
    PageIndicator(state.value.cardList.size, pagerState.currentPage)
    Tabs(
      tabs = state.value.tabsList,
      activeTab = state.value.activeTab,
      onTabClick = { tab -> viewModel.updateActiveTab(tab) }
    )
    ActionsLayout(
      actionsList = if(state.value.cardList[pagerState.currentPage].status == CARD_STATUS_ACTIVE) state.value.activeCardActions else state.value.blockedCardActions
    )
  }
}
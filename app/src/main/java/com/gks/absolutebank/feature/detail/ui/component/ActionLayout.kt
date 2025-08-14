package com.gks.absolutebank.feature.detail.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gks.absolutebank.feature.detail.domain.entity.CardActions
import com.gks.absolutebank.ui.theme.Typography

@Composable
fun ActionsLayout(
  actionsList: List<CardActions>
) {
  Column {
    actionsList.forEach {
      ActionLayout(
        it.iconResource,
        it.stringResource
      )
      if(it != actionsList.last()) {
        HorizontalDivider(
          color = MaterialTheme.colorScheme.secondaryContainer)
      }
    }
  }
}

@Composable
private fun ActionLayout(
  iconResource: Int,
  stringResource: Int
) {
  Row(
    modifier = Modifier
      .background(
        color = MaterialTheme.colorScheme.primary
      )
      .padding(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    Icon(
      painter = painterResource(iconResource),
      tint = MaterialTheme.colorScheme.tertiary,
      contentDescription = null
    )
    Text(
      text = stringResource(stringResource),
      color = MaterialTheme.colorScheme.onSecondary,
      style = Typography.bodyLarge
    )
  }
}
package com.gks.absolutebank.feature.main1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gks.absolutebank.R
import com.gks.absolutebank.ui.theme.Typography

@Composable
internal fun DepositLayout(
  modifier: Modifier = Modifier,
  currency: String,
  name: String,
  balance: Double,
  iconResource: Int,
) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .padding(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    Box(
      modifier = Modifier
        .background(
          color = MaterialTheme.colorScheme.primary,
          shape = RoundedCornerShape(999.dp)
        )
        .size(40.dp),
      contentAlignment = Alignment.Center
    ) {
      Icon(
        painter = painterResource(iconResource),
        tint = MaterialTheme.colorScheme.onTertiary,
        contentDescription = null
      )
    }
    Column(
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      Text(
        text = name,
        color = MaterialTheme.colorScheme.onTertiary,
        style = Typography.bodyLarge
      )
      Text(
        text = stringResource(R.string.balance_string, balance.toString(), currency),
        color = MaterialTheme.colorScheme.inversePrimary,
        style = Typography.bodyLarge
      )
    }
    Spacer(modifier = Modifier.weight(1f))
  }
}


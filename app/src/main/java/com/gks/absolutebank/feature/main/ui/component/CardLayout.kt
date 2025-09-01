package com.gks.absolutebank.feature.main1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gks.absolutebank.R
import com.gks.absolutebank.feature.main.ui.VISA_PAYMENT_SYSTEM
import com.gks.absolutebank.ui.theme.Typography

@Composable
internal fun CardLayout(
  modifier: Modifier = Modifier,
  number: String,
  status: String,
  paymentSystem: String,
  onCardClick: ()->Unit
) {
  Row(
    modifier = modifier
      .clickable(
        onClick = onCardClick
      )
      .padding(16.dp)
      .fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    Box(
      modifier = Modifier
        .background(
          color = Color.Transparent,
          shape = RoundedCornerShape(999.dp)
        )
        .size(40.dp),
      contentAlignment = Alignment.Center
    ) {
      Icon(
        painter = painterResource(R.drawable.ic_input_24),
        tint = MaterialTheme.colorScheme.onTertiary,
        contentDescription = null
      )
    }
    Column(
      verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
      Text(
        text = number,
        color = MaterialTheme.colorScheme.onTertiary,
        style = Typography.bodyLarge
      )
      Text(
        text = status,
        color = MaterialTheme.colorScheme.onTertiary,
        style = Typography.bodyMedium
      )
    }
    Spacer(modifier = Modifier.weight(1f))
    CardView(
      number = number.takeLast(4),
      iconResource = if (paymentSystem == VISA_PAYMENT_SYSTEM)
        R.drawable.ic_visa_16_6
      else R.drawable.ic_mastercard_16_12
      )
  }
}

@Composable
private fun CardView(
  modifier: Modifier = Modifier,
  number: String,
  iconResource: Int
) {
  Box(
    modifier = modifier
      .background(
        color = Color.Gray,
        shape = RoundedCornerShape(2.dp)
      )
      .width(40.dp)
      .height(28.dp),
    contentAlignment = Alignment.CenterEnd
  ) {
    Column(
      verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
      Text(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 2.dp),
        text = number,
        style = Typography.labelLarge,
        color = MaterialTheme.colorScheme.onTertiary,
        textAlign = TextAlign.Right
      )
      Row {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
          painter = painterResource(iconResource),
          tint = MaterialTheme.colorScheme.onTertiary,
          contentDescription = null
        )
      }
    }
  }
}
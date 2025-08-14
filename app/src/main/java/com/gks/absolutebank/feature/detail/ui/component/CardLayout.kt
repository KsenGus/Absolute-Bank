package com.gks.absolutebank.feature.detail.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gks.absolutebank.R
import com.gks.absolutebank.feature.detail.ui.mappers.maskCardNumber
import com.gks.absolutebank.ui.theme.Typography

@Composable
fun CardLayout(
  modifier: Modifier = Modifier,
  name: String,
  number: String,
  isActive: Boolean,
  expiresAt: String,
  paymentSystemImg: Int,
  textColor: Color,
  text: String
) {

  Column(
    modifier = modifier
      .background(
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = RoundedCornerShape(12.dp)
      )
      .height(if (isActive) 160.dp else 128.dp)
      .paint(
        painter = painterResource(R.drawable.card_background)
      )
      .padding(vertical = 24.dp, horizontal = 16.dp),
    verticalArrangement = Arrangement.SpaceBetween
  ) {
    Row(
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Image(
        modifier = Modifier
          .height(24.dp)
          .width(32.dp),
        painter = painterResource(paymentSystemImg),
        contentDescription = null
      )
      Text(
        text = name,
        color = MaterialTheme.colorScheme.onTertiary
      )
      Spacer(modifier = Modifier.weight(1f))
      Icon(
        painter = painterResource(R.drawable.ic_paypass_24),
        tint = MaterialTheme.colorScheme.onTertiary,
        contentDescription = null
      )
    }
    Text(
      text = text,
      style = Typography.titleLarge,
      color = textColor
    )
    Row {
      Text(
        text = maskCardNumber(number),
        style = Typography.bodyMedium,
        color = MaterialTheme.colorScheme.tertiary
      )
      Spacer(modifier = Modifier.weight(1f))
      Text(
        text = expiresAt,
        style = Typography.bodyMedium,
        color = MaterialTheme.colorScheme.tertiary
      )
    }
  }

}

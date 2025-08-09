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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gks.absolutebank.R

@Composable
internal fun DepositLayout(
  modifier: Modifier = Modifier,
  currency: String,
  name: String,
  balance: Double,
  iconResource: Int,
  term: String,
  rate: Double,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    Box(
      modifier = Modifier
        .background(
          color = Color(0xFF403A47),
          shape = RoundedCornerShape(999.dp)
        )
        .size(40.dp),
      contentAlignment = Alignment.Center
    ) {
      Icon(
        painter = painterResource(iconResource),
        tint = Color.White,
        contentDescription = null
      )
    }
    Column(
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      Text(
        text = name,
        color = Color.White,
        fontSize = 15.sp,
        fontWeight = FontWeight(400)
      )
      Text(
        text = balance.toString() + " " + currency,
        color = Color(0xFF6C78E6),
        fontSize = 15.sp,
        fontWeight = FontWeight(400)
      )
    }
    Spacer(modifier = Modifier.weight(1f))
    Column(
      verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
      Text(
        text = stringResource(R.string.rate) + " " + rate + "%",
        color = Color(0xFF706D76),
        fontSize = 11.sp,
        fontWeight = FontWeight(400)
      )
      Text(
        text = stringResource(R.string.up_to) + term,
        color = Color(0xFF706D76),
        fontSize = 11.sp,
        fontWeight = FontWeight(400)
      )
    }
  }
}


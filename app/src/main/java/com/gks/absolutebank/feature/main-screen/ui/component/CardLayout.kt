package com.gks.absolutebank.feature.main

import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gks.absolutebank.R

@Composable
fun CardLayout(
  number: String,
  status: String,
  paymentSystem: String
) {
  Row(
    modifier = Modifier
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
        tint = Color.White,
        contentDescription = null
      )
    }
    Column(
      verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
      Text(
        text = number,
        color = Color.White,
        fontSize = 15.sp,
        fontWeight = FontWeight(400)
      )
      Text(
        text = status,
        color = Color.White,
        fontSize = 13.sp,
        fontWeight = FontWeight(400)
      )
    }
    Spacer(modifier = Modifier.weight(1f))
    CardView(
      number = number.takeLast(4),
      iconResource = if (paymentSystem == stringResource(R.string.visa))
        R.drawable.ic_visa_16_6
      else R.drawable.ic_mastercard_16_12
      )
  }
}

@Composable
fun CardView(
  number: String,
  iconResource: Int
) {
  Box(
    modifier = Modifier
      .background(
        color = Color.Gray,
        shape = RoundedCornerShape(2.dp)
      )
      .width(40.dp)
      .height(28.dp)
  ) {
    Text(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 2.dp),
      text = number,
      fontSize = 10.sp,
      color = Color.White,
      textAlign = TextAlign.Right
    )
    Icon(
      painter = painterResource(iconResource),
      tint = Color.Transparent,
      contentDescription = null
    )
  }
}
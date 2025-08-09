package com.gks.absolutebank.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gks.absolutebank.R

@Composable
fun AccountLayout(
  currency: String,
  number: String,
  balance: Double,
  iconResource: Int,
  onExpandClick: ()->Unit,
  isExpanded: Boolean,
  cards: List<Card>,
) {
  Column {
    Row(
      modifier = Modifier
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
          text = number,
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
      ExpandControl(
        onClick = onExpandClick
      )
    }
    //if(isExpanded) {
      for(i in 0..cards.size-1) {
        CardLayout(
          number = cards[i].number,
          status = cards[i].status,
          paymentSystem = cards[i].paymentSystem
        )
      //}
      /*LazyColumn(
      ) {
        items(cards){
          card -> CardLayout(
            number = card.number,
            status = card.status,
            statusColor = Color.Red
          )
        }
      }*/
    }
  }

}

@Composable
fun ExpandControl(
  onClick: ()->Unit
) {
  Box(
    modifier = Modifier
      .clickable(
        onClick = onClick
      )
      .background(color = Color(0xFF403A47),)
      .width(40.dp)
      .height(28.dp)
  ) {
    Icon(
      painter = painterResource(R.drawable.ic_chevron_down_24),
      contentDescription = null,
      tint = Color(0xFF706D76)
    )
  }
}
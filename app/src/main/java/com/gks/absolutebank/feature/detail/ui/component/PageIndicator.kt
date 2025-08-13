package com.gks.absolutebank.feature.detail.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun PageIndicator(pageCount: Int, currentPageIndex: Int, modifier: Modifier = Modifier) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .padding(vertical = 8.dp),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    repeat(pageCount) { iteration ->
      val color = if (currentPageIndex == iteration) Color.White else Color.LightGray
      val size = if (currentPageIndex == iteration) 8.dp else 6.dp
      Box(
        modifier = Modifier
          .padding(2.dp)
          .clip(shape = CircleShape)
          .background(color)
          .size(size)
      )
    }
  }
}
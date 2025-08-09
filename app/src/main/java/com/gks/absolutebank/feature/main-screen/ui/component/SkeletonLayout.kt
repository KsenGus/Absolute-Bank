package com.gks.absolutebank.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonLayout() {
  Column(
    modifier = Modifier
      .background(
        color = Color(0xFF312C39)
      )
      .fillMaxHeight()
      .systemBarsPadding()
  ) {
    Spacer(modifier = Modifier.height(11.dp))
    Box(
      modifier = Modifier
        .height(32.dp)
        .width(160.dp)
        .shimmerBackground()
    )
    Spacer(modifier = Modifier.height(11.dp))
    Column(
      modifier = Modifier
        .background(
          color = Color(0xFF352F3D)
        )
    ) {
      Box(
        modifier = Modifier
          .height(14.dp)
          .width(72.dp)
          .shimmerBackground()
      )

      Row(
        modifier = Modifier
          .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Box(
          modifier = Modifier
            .size(40.dp)
            .shimmerBackground(),
        )
        Column(
          verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(16.dp)
              .shimmerBackground()
          )
          Box(
            modifier = Modifier
              .width(132.dp)
              .height(12.dp)
              .shimmerBackground()
          )
        }
      }
    }
  }
}
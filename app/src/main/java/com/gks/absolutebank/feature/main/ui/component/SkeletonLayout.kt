package com.gks.absolutebank.feature.main1

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.unit.dp
import com.gks.absolutebank.feature.main.ui.component.shimmerBackground

@Composable
fun SkeletonLayout() {
  Column(
    modifier = Modifier
      .background(
        color = MaterialTheme.colorScheme.primary
      )
      .fillMaxHeight()
      .systemBarsPadding()
  ) {
    Spacer(modifier = Modifier.height(11.dp))
    Box(
      modifier = Modifier
        .clip(RoundedCornerShape(12.dp))
        .height(32.dp)
        .width(160.dp)
        .shimmerBackground()
    )
    Spacer(modifier = Modifier.height(11.dp))
    Column(
      modifier = Modifier
        .clip(RoundedCornerShape(12.dp))
        .padding(top = 16.dp)
        .background(
          color = MaterialTheme.colorScheme.secondary
        )
    ) {
      Spacer(modifier = Modifier.height(20.dp))
      Box(
        modifier = Modifier
          .clip(RoundedCornerShape(12.dp))
          .height(14.dp)
          .width(72.dp)
          .shimmerBackground()
      )

      LazyColumn {
        items(3) { item ->
          SkeletonRow()
        }
        item {
          Box(
            modifier = Modifier
              .background(color = MaterialTheme.colorScheme.primary)
              .fillMaxWidth()
              .height(16.dp)
          )
        }
        items(3) { item ->
          SkeletonRow()
        }
      }
    }
  }
}

private @Composable
fun SkeletonRow() {
  Row(
    modifier = Modifier
      .padding(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    Box(
      modifier = Modifier
        .clip(shape = RoundedCornerShape(999.dp))
        .size(40.dp)
        .shimmerBackground(),
    )
    Column(
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      Box(
        modifier = Modifier
          .clip(RoundedCornerShape(12.dp))
          .fillMaxWidth()
          .height(16.dp)
          .shimmerBackground()
      )
      Box(
        modifier = Modifier
          .clip(RoundedCornerShape(12.dp))
          .width(132.dp)
          .height(12.dp)
          .shimmerBackground()
      )
    }
  }
}
package com.gks.absolutebank.feature.detail.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gks.absolutebank.feature.detail.domain.entity.Tabs

@Composable
fun Tabs(
  tabs: List<Tabs>,
  activeTab: Tabs,
  onTabClick: (Tabs)->Unit
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 16.dp, horizontal = 36.dp),
    horizontalArrangement = Arrangement.Center,
  ) {
    tabs.forEach{ tab ->
      Tab(
        iconResource = tab.iconResource,
        isActive = tab == activeTab,
        onClick = {onTabClick(tab)}
      )
      if(tab != tabs.last()) {
        Spacer(modifier = Modifier.width(40.dp))
      }
    }
  }
}

@Composable
private fun Tab(
  modifier: Modifier = Modifier,
  iconResource: Int,
  isActive: Boolean,
  onClick: ()->Unit
) {
  Box(
    modifier = modifier
      .clickable(
        onClick = onClick
      )
      .background(
       color = if(isActive) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.secondary,
        shape = CircleShape
      )
      .size(56.dp),
    contentAlignment = Alignment.Center
  ){
    Icon(
      painter = painterResource(iconResource),
      tint = if(isActive) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.onTertiary,
      contentDescription = null
    )
  }
}
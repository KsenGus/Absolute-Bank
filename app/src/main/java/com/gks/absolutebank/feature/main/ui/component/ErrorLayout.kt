package com.gks.absolutebank.feature.main.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gks.absolutebank.R

@Composable
fun ErrorLayout() {
  Text(
    modifier = Modifier
      .padding(vertical = 20.dp),
    text = stringResource(R.string.something_went_wrong),
    color = MaterialTheme.colorScheme.error
  )
}
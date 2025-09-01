package com.gks.absolutebank.feature.main.domain.entity

import androidx.compose.runtime.Immutable

@Immutable
sealed class ContentLoadState {
  data object NotStarted: ContentLoadState()
  data object Loading: ContentLoadState()
  data object Ready: ContentLoadState()
  data class Error(val error: Throwable): ContentLoadState()
}
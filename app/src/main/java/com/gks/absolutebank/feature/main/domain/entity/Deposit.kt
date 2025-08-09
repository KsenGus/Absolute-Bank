package com.gks.absolutebank.feature.main.domain.entity

import androidx.compose.runtime.Immutable
import com.gks.absolutebank.feature.main1.Id

@Immutable
data class Deposit(
  val id: Id,
  val name: String,
  val balance: Double,
  val currency: String,
  val status: String,
  val term: String,
  val rate: Double,
  val minSize: Double
)
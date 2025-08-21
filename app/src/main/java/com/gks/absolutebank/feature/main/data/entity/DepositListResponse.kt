package com.gks.absolutebank.feature.main.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class DepositListResponse (
  val deposits: List<DepositData>
)

@Serializable
data class DepositData(
  val depositId: Int,
  val balance: Double,
  val currency: String,
  val status: String,
  val name: String
)
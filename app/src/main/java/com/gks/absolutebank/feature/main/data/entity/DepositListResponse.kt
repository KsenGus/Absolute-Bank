package com.gks.absolutebank.feature.main.data.entity

data class DepositListResponse (
  val deposits: List<DepositData>
)

data class DepositData(
  val depositId: Int,
  val balance: Double,
  val currency: String,
  val status: String,
  val name: String
)
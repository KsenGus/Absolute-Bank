package com.gks.absolutebank.feature.detail.domain.entity

import com.gks.absolutebank.R

enum class Tabs(
  val iconResource: Int
) {
  HISTORY(
    iconResource = R.drawable.ic_history_24
  ),
  ACTIONS(
    iconResource = R.drawable.ic_card_24
  ),
  PAYMENTS(
    iconResource = R.drawable.ic_payment_24
  ),
}
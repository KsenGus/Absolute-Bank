package com.gks.absolutebank.feature.detail.domain.entity

import com.gks.absolutebank.R

enum class CardActions (
  val iconResource: Int,
  val stringResource: Int
) {
  RENAME(
    iconResource = R.drawable.ic_pencil_24,
    stringResource = R.string.rename
  ),
  REQUISITES(
    iconResource = R.drawable.ic_cardpay_24,
    stringResource = R.string.requisites),
  INFORMATION(
    iconResource = R.drawable.ic_obtain_24,
    stringResource = R.string.information
  ),
  OBTAIN(
    iconResource = R.drawable.ic_info_24,
    stringResource = R.string.obtain
  ),
  REOBTAIN(
    iconResource = R.drawable.ic_info_24,
    stringResource = R.string.reobtain
  ),
  BLOCK(
    iconResource = R.drawable.ic_block_24,
    stringResource = R.string.block
  ),
  UNBLOCK(
    iconResource = R.drawable.ic_block_24,
    stringResource = R.string.unblock
  ),
}
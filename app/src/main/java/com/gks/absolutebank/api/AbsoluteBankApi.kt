package com.gks.absolutebank.api

import com.gks.absolutebank.feature.main.data.entity.AccountListResponse
import com.gks.absolutebank.feature.main.data.entity.DepositListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface AbsoluteBankApi{
  @Headers(
    "Authorization: Bearer 123"
  )
  @GET ("api/core/account/list")
  suspend fun fetchAccountList(): AccountListResponse

  @Headers(
    "Authorization: Bearer 123"
  )
  @GET ("api/core/deposit/list")
  suspend fun fetchDepositList(): DepositListResponse
}


package com.gks.absolutebank.feature.main.data.di

import com.gks.absolutebank.api.AbsoluteBankApi
import com.gks.absolutebank.feature.main.data.MainScreenDataRepository
import com.gks.absolutebank.feature.main.domain.MainScreenRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
abstract class MainScreenDataModule {
  @Binds
  abstract fun bindMainScreenRepository(dataRepository: MainScreenDataRepository) : MainScreenRepository
}

@Module
@InstallIn(SingletonComponent::class)
data object NetworkModule {

  @Provides
  fun provideOkHttp(): OkHttpClient {
    return OkHttpClient.Builder()
      .connectTimeout(3, TimeUnit.MINUTES)
      .readTimeout(3, TimeUnit.MINUTES)
      .writeTimeout(3, TimeUnit.MINUTES)
      .apply {
        val loggingInterceptor = HttpLoggingInterceptor { message -> println(message) }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        addNetworkInterceptor(loggingInterceptor)
      }
      .build()
  }

  @Provides
  fun providesJson(): Json {
    return Json {
      ignoreUnknownKeys = true
      encodeDefaults = true
      explicitNulls = false
    }
  }

  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://stoplight.io/mocks/kode-api/kode-bank/6096726/")
      .client(okHttpClient)
      .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
      .build()
  }

  @Provides
  fun provideAbsoluteBankApi(retrofit: Retrofit): AbsoluteBankApi {
    return retrofit.create(AbsoluteBankApi::class.java)
  }
}
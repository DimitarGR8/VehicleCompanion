package com.vehiclecompanion.remote.di

import com.google.gson.Gson
import com.vehiclecompanion.data.BuildConfig
import com.vehiclecompanion.remote.api.FeaturesApi
import com.vehiclecompanion.remote.api.RequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    companion object {
        const val TIMEOUT_SECONDS = 60L
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    @OkHttpLoggingInterceptor
    fun provideLoggingInterceptor(): Interceptor? {
        return if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        } else {
            null
        }
    }

    @Singleton
    @Provides
    @OkHttpRequestInterceptor
    fun provideRequestInterceptor(): Interceptor = RequestInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @OkHttpLoggingInterceptor loggingInterceptor: Interceptor?,
        @OkHttpRequestInterceptor requestInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(requestInterceptor)
        .apply {
            loggingInterceptor?.let { interceptor ->
                addInterceptor(interceptor)
            }
        }
        .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL) // Assuming BuildConfig.BASE_URL is a String constant
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME) // Important for Dagger to retain at runtime
    annotation class OkHttpLoggingInterceptor

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME) // Important for Dagger to retain at runtime
    annotation class OkHttpRequestInterceptor

    @Provides
    @Singleton
    fun provideCoreApi(retrofitBuilder: Retrofit.Builder): FeaturesApi {
        return retrofitBuilder.build().create(FeaturesApi::class.java)
    }
}

package xyz.ivankocijan.kotlinexample.dagger.setup.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import xyz.ivankocijan.kotlinexample.BuildConfig
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
@Module
class ClientModule {

    @Provides
    @Singleton
    fun provideClient(networkTimeoutSecond: Long, logger: HttpLoggingInterceptor): OkHttpClient {

        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.readTimeout(networkTimeoutSecond, TimeUnit.SECONDS)
        okHttpClientBuilder.connectTimeout(networkTimeoutSecond, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {

            logger.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(logger)
        }

        return okHttpClientBuilder.build()

    }

}
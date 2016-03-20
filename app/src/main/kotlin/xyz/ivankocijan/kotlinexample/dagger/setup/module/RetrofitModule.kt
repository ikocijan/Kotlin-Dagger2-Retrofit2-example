package xyz.ivankocijan.kotlinexample.dagger.setup.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import xyz.ivankocijan.kotlinexample.PokemonService
import javax.inject.Singleton

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient, baseUrl: String, converter: Converter.Factory): Retrofit {

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .client(httpClient).build()

    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): PokemonService {
        return retrofit.create(PokemonService::class.java)
    }

}
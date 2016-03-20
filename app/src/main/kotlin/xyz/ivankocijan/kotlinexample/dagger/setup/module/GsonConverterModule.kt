package xyz.ivankocijan.kotlinexample.dagger.setup.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
@Module
class GsonConverterModule {

    @Provides
    @Singleton
    fun provideConverter(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

}
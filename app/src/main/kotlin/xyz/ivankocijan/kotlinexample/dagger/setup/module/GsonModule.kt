package xyz.ivankocijan.kotlinexample.dagger.setup.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
@Module
class GsonModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

}
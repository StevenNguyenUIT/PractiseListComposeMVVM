package com.nhinhnguyenuit.practiselistcomposemvvm.di

import android.content.Context
import com.nhinhnguyenuit.practiselistcomposemvvm.data.repository.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(@ApplicationContext context: Context) : RestaurantRepository{
        return RestaurantRepository(context)
    }
}
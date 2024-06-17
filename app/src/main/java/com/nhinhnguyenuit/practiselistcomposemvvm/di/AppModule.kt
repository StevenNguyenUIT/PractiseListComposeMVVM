package com.nhinhnguyenuit.practiselistcomposemvvm.di

import com.nhinhnguyenuit.practiselistcomposemvvm.data.repository.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository() : RestaurantRepository{
        return RestaurantRepository()
    }
}